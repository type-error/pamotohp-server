package org.tapaha.pamotohp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tapaha.pamotohp.domain.Photo;
import org.tapaha.pamotohp.repository.PhotoRepository;

@Service
public class PhotoServiceImpl implements PhotoService {
	@Autowired
	private PhotoRepository photoRepository;
	
	public Photo save(Photo photo) {
		return photoRepository.save(photo);
	}
	
	public Iterable<Photo> saves(List<Photo> photos) {
		return photoRepository.save(photos);
	}
}
