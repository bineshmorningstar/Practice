package com.goeuro.handler;

import org.json.JSONArray;

import com.goeuro.request.Request;
import com.goeuro.service.CityDataService;
import com.goeuro.service.ICityDataService;

/**
 * Handles the request to pull data from endpoint and write to file.
 * @author Binesh
 *
 */
public abstract class RequestHandler {
	
	private JSONArray cityData;
	
	/**
	 * Retrieves the information of the city queried.
	 * @param cityName
	 */
	public void getCityData(String cityName){
		ICityDataService cityDataService = new CityDataService();
		cityData = cityDataService.getCityData(cityName);
	}
	
	/**
	 * Handles the request to get the city information and write to file.
	 * @param request
	 */
	public void handleRequest(Request request) {
		getCityData(request.getCityName());
		exportToFile(request.getCityName());
	}
	
	public abstract void exportToFile(String cityName);
	
	public JSONArray getCityData() {
		return cityData;
	}

}
