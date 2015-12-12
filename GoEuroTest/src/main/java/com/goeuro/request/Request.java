package com.goeuro.request;

import com.goeuro.exception.NoInputException;

public class Request {
	
	private String cityName;
	private String outputFormat;
	
	public Request(String[] input) throws NoInputException {
		if(input.length > 0){
        	cityName = input[0];
        	if(input.length < 2){
        		outputFormat = "CSV";	
        	} else {
        		outputFormat = input[1];
        	}
        } else {
        	throw new NoInputException("No Input Provided!!");
        }
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@Override
	public String toString() {
		return cityName;
	}
}
