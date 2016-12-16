package org.tapaha.pamotohp.web;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tapaha.PamotohpGdManager;

import com.google.api.services.drive.model.File;
import org.tapaha.pamotohp.service.PhotoService;

import org.tapaha.pamotohp.domain.Photo;
import org.tapaha.pamotohp.service.GeocodingService;

public class SynchronizeController {

	@Autowired
	private PhotoService service;
	
	private void savePhoto(File file, String country) {
		String s = file.getImageMediaMetadata().getTime();
		String t = "";
		
		if(s != null) {
			boolean flag = Pattern.matches("^\\d{4}:\\d{2}:\\d{2} \\d{2}:\\d{2}:\\d{2}", s);
			
			if(flag) {
				String[] date = s.split(" ")[0].split(":");
				String[] time = s.split(" ")[1].split(":");
				
				DateTime dt = new DateTime(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]), DateTimeZone.UTC);
				
				DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
				
				t = fmt.print(dt);	
			} else {
				// ex> 17/02/2015 5:32
				flag = Pattern.matches("^\\d{2}/\\d{2}/\\d{4} \\d+:\\d{2}", s);
				
				if(flag) {
					String[] date = s.split(" ")[0].split("/");
					String[] time = s.split(" ")[1].split(":");
					
					DateTime dt = new DateTime(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]), Integer.parseInt(time[0]), Integer.parseInt(time[1]), 0, DateTimeZone.UTC);
					
					DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
					
					t = fmt.print(dt);
				}
			}
			
		} else {
			t = s;
		}
		
		service.save(new Photo(file.getId(), file.getName(), file.getOriginalFilename(), file.getQuotaBytesUsed(), file.getSize(), file.getFileExtension(), file.getFullFileExtension(),
				file.getHeadRevisionId(), file.getCreatedTime().toString(), file.getStarred(), file.getThumbnailLink(), file.getTrashed(), file.getVersion(), file.getImageMediaMetadata().getAperture(), file.getImageMediaMetadata().getCameraMake(),
				file.getImageMediaMetadata().getCameraModel(), file.getImageMediaMetadata().getColorSpace(), file.getImageMediaMetadata().getExposureBias(), file.getImageMediaMetadata().getExposureMode(), file.getImageMediaMetadata().getExposureTime(),
				file.getImageMediaMetadata().getFlashUsed(), file.getImageMediaMetadata().getFocalLength(), file.getImageMediaMetadata().getWidth(), file.getImageMediaMetadata().getHeight(),
				file.getImageMediaMetadata().getIsoSpeed(), file.getImageMediaMetadata().getLocation() == null ? new GeoPoint(0, 0) : new GeoPoint(file.getImageMediaMetadata().getLocation().getLatitude(), file.getImageMediaMetadata().getLocation().getLongitude()),
				file.getImageMediaMetadata().getMeteringMode(), file.getImageMediaMetadata().getRotation(), file.getImageMediaMetadata().getSensor(), t,
				file.getImageMediaMetadata().getWhiteBalance(), file.getKind(), file.getMd5Checksum(), file.getMimeType(), country
		));
		
	}
	
	private void savePhoto(List<Photo> photos) {
		service.saves(photos);
	}
	
	@RequestMapping("/synchronize")
	public int es() {
		GeocodingService gs = new GeocodingService();
		
		List<File> result = null;
		
		int counterGetFileInfo = 0;
		
		try {
			result = PamotohpGdManager.getFiles();
			
			for(File file : result) {
				System.out.println("get file info : " + ++counterGetFileInfo);
				
				//if(counterGetFileInfo >= 11320) {
					if(file.getName().toUpperCase().contains("JPG") || file.getName().toUpperCase().contains("JPEG")) {
						File f = PamotohpGdManager.getFile(file.getId());
						
						if(f.getImageMediaMetadata().getLocation() != null) {
							savePhoto(f, gs.reverseGeocode(f.getImageMediaMetadata().getLocation().getLatitude(), f.getImageMediaMetadata().getLocation().getLongitude()));
						} else {
							savePhoto(f, "none");
						}	
				 //}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.size();
		
		//return 0;
	}
}
