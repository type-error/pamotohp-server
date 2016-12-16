package org.tapaha.pamotohp.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.tapaha.pamotohp.domain.Photo;

@Repository
public interface PhotoRepository extends ElasticsearchRepository<Photo, String> {
	
	public Photo findById(String id);
	public List<Photo> findByFileExtension(String fileExtension);
	public List<Photo> findByCountry(String country);
	public List<Photo> findByCreatedTime(String createdTime);
}
