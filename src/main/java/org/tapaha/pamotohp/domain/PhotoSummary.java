package org.tapaha.pamotohp.domain;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

public class PhotoSummary {
	private String id;
	private Integer originalWidth;
	private Integer originalHeight;
	private Integer width;
	private Integer height;
	private GeoPoint location;
	private Integer rotation;
	private String time;
	private String mimeType;
	private String country;
	
	public PhotoSummary() {}
	
	public PhotoSummary(String id, Integer originalWidth, Integer originalHeight, Integer width, Integer height, GeoPoint location, Integer rotation, String time, String mimeType, String country) {
		this.id = id;
		this.originalWidth = originalWidth;
		this.originalHeight = originalHeight;
		this.width = width;
		this.height = height;
		this.location = location;
		this.rotation = rotation;
		this.time = time;
		this.mimeType = mimeType;
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getOriginalWidth() {
		return originalWidth;
	}

	public void setOriginalWidth(Integer originalWidth) {
		this.originalWidth = originalWidth;
	}

	public Integer getOriginalHeight() {
		return originalHeight;
	}

	public void setOriginalHeight(Integer originalHeight) {
		this.originalHeight = originalHeight;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public GeoPoint getLocation() {
		return location;
	}

	public void setLocation(GeoPoint location) {
		this.location = location;
	}

	public Integer getRotation() {
		return rotation;
	}

	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
