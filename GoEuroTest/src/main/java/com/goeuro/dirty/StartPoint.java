package com.goeuro.dirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

public class StartPoint {
	
	public static final String ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	public static void main(String[] args) {
		StartPoint sp = new StartPoint();
		sp.getCityInfo("BERLIN");
	}
	
	protected String getCityInfo(String cityName){
		try {
			StringBuilder stringInput = new StringBuilder(ENDPOINT).append(cityName);
			URL restServiceURL = new URL(stringInput.toString());

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
			System.out.println("Output from Server:  \n");
			StringBuilder jsonString = new StringBuilder();

			while ((output = responseBuffer.readLine()) != null) {
				//System.out.println(output);
				jsonString.append(output);
			}

			httpConnection.disconnect();
			
			jsonString.deleteCharAt(0);
			jsonString.deleteCharAt(jsonString.length()-1);
			
			
			
			JSONObject json = new JSONObject(jsonString.toString());
			System.out.println(json.toString());

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		return null;
	}
}
