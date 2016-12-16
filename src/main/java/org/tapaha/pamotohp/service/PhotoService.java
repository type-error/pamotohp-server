package org.tapaha.pamotohp.service;

import java.util.List;

import org.tapaha.pamotohp.domain.Photo;

public interface PhotoService {
	Photo save(Photo photo);
	Iterable<Photo> saves(List<Photo> photos);
}
