package org.tapaha.pamotohp.domain;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

@Document(indexName = "photos", type = "photo", shards = 5, replicas = 0, refreshInterval = "-1")
public class Photo {
	
	@Id
	private String id;
	
	private String fileExtension;
	private String fullFileExtension;
	private String headRevisionId;
	private String createdTime;
	
	private Float aperture;
	private String cameraMake;
	private String cameraMode;
	private String colorSpace;
	private Float exposureBias;
	private String exposureMode;
	private Float exposureTime;
	private Boolean flashUsed;
	private Float focalLength;
	private Integer width;
	private Integer height;
	private Integer isoSpeed;
	@GeoPointField
	private GeoPoint location;
	private String meteringMode;
	private Integer rotation;
	private String sensor;
	private String time;
	private String whiteBalance;

	private String kind;
	private String md5Checksum;
	private String mimeType;
	private String name;
	private String originalFilename;
	private String country;
	private Long quotaByteUsed;
	private Long size;
	private Boolean starred;
	private String thumbnailLink;
	private Boolean trahsed;
	private Long version;
	
	public Photo() {}
	
	public Photo(String id, String name, String originalFilename, Long quotaByteUsed, Long size, String fileExtension, String fullFileExtension, 
			String headRevisionId, String createdTime , Boolean starred, String thumbnailLink, Boolean trahsed, Long version, Float aperture, String cameraMake,
			String cameraMode, String colorSpace, Float exposureBias, String exposureMode, Float exposureTime, Boolean flashUsed, Float focalLength, Integer width, Integer height, 
			Integer isoSpeed, GeoPoint location, String meteringMode, Integer rotation, String sensor, String time, String whiteBalance,
			String kind, String md5Checksum, String mimeType, String country) {
		
		this.id = id;
		this.name = name;
		this.originalFilename = originalFilename;
		this.quotaByteUsed = quotaByteUsed;
		this.size = size;
		this.fileExtension = fileExtension;
		this.fullFileExtension = fullFileExtension;
		this.headRevisionId = headRevisionId;
		this.createdTime = createdTime;
		this.starred = starred;
		this.thumbnailLink = thumbnailLink;
		this.trahsed = trahsed;
		this.version = version;
		this.aperture = aperture;
		this.cameraMake = cameraMake;
		this.cameraMode = cameraMode;
		this.colorSpace = colorSpace;
		this.exposureBias = exposureBias;
		this.exposureMode = exposureMode;
		this.exposureTime = exposureTime;
		this.flashUsed = flashUsed;
		this.focalLength = focalLength;
		this.height = height;
		this.width = width;
		this.isoSpeed = isoSpeed;
		this.location = location;
		this.meteringMode = meteringMode;
		this.rotation = rotation;
		this.sensor = sensor;
		this.time = time;
		this.whiteBalance = whiteBalance;
		this.kind = kind;
		this.md5Checksum = md5Checksum;
		this.mimeType = mimeType;
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFullFileExtension() {
		return fullFileExtension;
	}

	public void setFullFileExtension(String fullFileExtension) {
		this.fullFileExtension = fullFileExtension;
	}

	public String getHeadRevisionId() {
		return headRevisionId;
	}

	public void setHeadRevisionId(String headRevisionId) {
		this.headRevisionId = headRevisionId;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public Float getAperture() {
		return aperture;
	}

	public void setAperture(Float aperture) {
		this.aperture = aperture;
	}

	public String getCameraMake() {
		return cameraMake;
	}

	public void setCameraMake(String cameraMake) {
		this.cameraMake = cameraMake;
	}

	public String getCameraMode() {
		return cameraMode;
	}

	public void setCameraMode(String cameraMode) {
		this.cameraMode = cameraMode;
	}

	public String getColorSpace() {
		return colorSpace;
	}

	public void setColorSpace(String colorSpace) {
		this.colorSpace = colorSpace;
	}

	public Float getExposureBias() {
		return exposureBias;
	}

	public void setExposureBias(Float exposureBias) {
		this.exposureBias = exposureBias;
	}

	public String getExposureMode() {
		return exposureMode;
	}

	public void setExposureMode(String exposureMode) {
		this.exposureMode = exposureMode;
	}

	public Float getExposureTime() {
		return exposureTime;
	}

	public void setExposureTime(Float exposureTime) {
		this.exposureTime = exposureTime;
	}

	public Boolean isFlashUsed() {
		return flashUsed;
	}

	public void setFlashUsed(Boolean flashUsed) {
		this.flashUsed = flashUsed;
	}

	public Float getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(Float focalLength) {
		this.focalLength = focalLength;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getIsoSpeed() {
		return isoSpeed;
	}

	public void setIsoSpeed(Integer isoSpeed) {
		this.isoSpeed = isoSpeed;
	}

	public GeoPoint getLocation() {
		return location;
	}

	public void setLocation(GeoPoint location) {
		this.location = location;
	}

	public String getMeteringMode() {
		return meteringMode;
	}

	public void setMeteringMode(String meteringMode) {
		this.meteringMode = meteringMode;
	}

	public Integer getRotation() {
		return rotation;
	}

	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}

	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWhiteBalance() {
		return whiteBalance;
	}

	public void setWhiteBalance(String whiteBalance) {
		this.whiteBalance = whiteBalance;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getMd5Checksum() {
		return md5Checksum;
	}

	public void setMd5Checksum(String md5Checksum) {
		this.md5Checksum = md5Checksum;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public Long getQuotaByteUsed() {
		return quotaByteUsed;
	}

	public void setQuotaByteUsed(Long quotaByteUsed) {
		this.quotaByteUsed = quotaByteUsed;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Boolean isStarred() {
		return starred;
	}

	public void setStarred(Boolean starred) {
		this.starred = starred;
	}

	public String getThumbnailLink() {
		return thumbnailLink;
	}

	public void setThumbnailLink(String thumbnailLink) {
		this.thumbnailLink = thumbnailLink;
	}

	public Boolean isTrahsed() {
		return trahsed;
	}

	public void setTrahsed(Boolean trahsed) {
		this.trahsed = trahsed;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
