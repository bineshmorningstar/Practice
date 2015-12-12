package com.goeuro.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;

public class CityDataService implements ICityDataService {
	
	public static final String ENDPOINT_FOR_ENGLISH = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	public JSONArray getCityData(String cityName) {
		StringBuilder jsonString = new StringBuilder();
		try {
			URL restServiceURL = new URL(new StringBuilder(ENDPOINT_FOR_ENGLISH).append(cityName).toString());

			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/json");

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("HTTP GET Request Failed with Error code : "
						+ httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
				(httpConnection.getInputStream())));
			String output;
			while ((output = responseBuffer.readLine()) != null) {
				jsonString.append(output);
			}

			httpConnection.disconnect();

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			return new JSONArray();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return new JSONArray();
		}
		return new JSONArray(jsonString.toString());
	}
}
