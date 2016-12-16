package org.tapaha.pamotohp.web;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tapaha.PamotohpGdManager;
import org.tapaha.pamotohp.domain.Photo;
import org.tapaha.pamotohp.domain.PhotoSummary;

@CrossOrigin(origins = "*")
@RestController
public class PamotohpController {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	/*
	 * /photo/country/{country}
	 *	/photo/date/{date}
	 * /photo/date/{from-date}/{to-date}
	 * /photo/weather/{weather}
	 */

	@RequestMapping("/photo/country/{country}/{page}")
	public @ResponseBody List<PhotoSummary> getPhotoByCountry(@PathVariable("country") String country, @PathVariable("page") int page) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(matchQuery("country", country))
				.withQuery(matchQuery("rotation", 0))
				.withPageable(new PageRequest(page - 1, 5))
				.build();

		List<Photo> result = elasticsearchTemplate.queryForList(searchQuery, Photo.class);
		List<PhotoSummary> photos = new ArrayList<PhotoSummary>();

		double fixedWidth = 1280;
		double fixedHeight = 1024;

		for(Photo p : result) {
			int resizeWidth, resizeHeight;
			double ratio;

			if(p.getWidth() > p.getHeight()) {
				ratio = fixedWidth / p.getWidth();
			} else {
				ratio = fixedHeight / p.getHeight();
			}

			resizeWidth = (int) (ratio * p.getWidth());
			resizeHeight = (int) (ratio * p.getHeight()); 

			photos.add(new PhotoSummary(p.getId(), p.getWidth(), p.getHeight(), resizeWidth, resizeHeight, p.getLocation(), p.getRotation(), p.getTime(), p.getMimeType(), p.getCountry() ));
		}

		return photos;
	}

	@RequestMapping("/photo/date/{start}/{end}/{page}")
	public @ResponseBody List<Photo> getPhotoByDateRange(@PathVariable("start") String start, @PathVariable("end") String end, @PathVariable("page") int page) {
		RangeQueryBuilder queryDate = QueryBuilders.rangeQuery("time").to(end).from(start);

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(matchAllQuery())
				.withFilter(queryDate)
				.withPageable(new PageRequest(page - 1, 20))
				.build();

		List<Photo> photos = elasticsearchTemplate.queryForList(searchQuery, Photo.class);

		return photos;
	}
	
	@RequestMapping("/photo/image/{id}/{w}/{h}")
	public ResponseEntity<InputStreamResource> image(@PathVariable("id") String id, @PathVariable("w") int w, @PathVariable("h") int h) throws IOException {
		GetQuery getQuery = new GetQuery();
		getQuery.setId(id);
		
		Photo p = elasticsearchTemplate.queryForObject(getQuery, Photo.class);
		
		ByteArrayOutputStream outputStream = PamotohpGdManager.getBufferedImage(id, w, h, p.getWidth(), p.getHeight(), p.getRotation());
		
		InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(outputStream.toByteArray()));
		
		return ResponseEntity.ok().contentLength(outputStream.size()).contentType(MediaType.IMAGE_JPEG).body(resource);	
	}
}
