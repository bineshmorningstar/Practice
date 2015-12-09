package com.goeuro.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public abstract class GenericDataService {
	
	public static final String ENDPOINT_CONFIG = "endpoint.properties";
	private Properties endpoint;
	
	public GenericDataService(){
		try {
			endpoint = new Properties();
			InputStream input = new FileInputStream(ENDPOINT_CONFIG);
			endpoint.load(input);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Properties getEndpoint() {
		return endpoint;
	}
	
}
