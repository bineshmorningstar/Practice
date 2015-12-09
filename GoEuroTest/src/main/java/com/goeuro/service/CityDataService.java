package com.goeuro.service;

import java.util.Properties;

import com.goeuro.request.Request;

public class CityDataService extends GenericDataService implements ICityDataService {
	
	public CityDataService(){
		super();
	}

	public void getCityData(Request request) {
		Properties endpoint = getEndpoint();
		String endpoint_for_english = endpoint.get("endpoint_for_english").toString();
		
	}
}
