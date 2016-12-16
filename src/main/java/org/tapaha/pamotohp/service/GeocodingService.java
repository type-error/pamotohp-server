package org.tapaha.pamotohp.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.LocationType;

public class GeocodingService {

	public GeocodingService() {}
	
	public String reverseGeocode(double lat, double lng) throws Exception {
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBRYNDjUeuoLpiD8JK1JXD6sEYvkxvgwQM");
		
		GeocodingResult[] results = GeocodingApi.newRequest(context)
				.latlng(new LatLng(lat, lng)).language("en")
				.resultType(AddressType.COUNTRY).await();
	
		return results[0].formattedAddress;
	}
}
