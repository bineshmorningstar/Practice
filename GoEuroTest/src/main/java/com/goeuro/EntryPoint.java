package com.goeuro;

import com.goeuro.exception.NoInputException;
import com.goeuro.request.Request;

public class EntryPoint 
{
    public static void main(String[] args)
    {
        EntryPoint entry = new EntryPoint();
        try {
        	entry.getCityData(args);	
		} catch (NoInputException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    public void getCityData(String[] input) throws Exception{
		if(input.length > 0){
        	Request request = new Request();
        	String cityName = input[0];
        	request.setCityName(cityName);
        	
        	if(input.length == 1){
            	request.setOutputFormat("CSV");	
        	} else {
        		request.setOutputFormat(input[1]);
        	}
        } else {
        	throw new NoInputException("No Input Provided!!");
        }
    }
}
