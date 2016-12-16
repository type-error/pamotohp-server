package org.tapaha.pamotohp.domain;

public class Location {
	
	private Double altitude;
	private Double latitude;
	private Double longitude;
	
	public Location() {}
	
	public Location(Double altitude, Double latitude, Double longitude) {
		this.altitude = altitude;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
}
