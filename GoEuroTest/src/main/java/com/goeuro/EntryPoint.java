package com.goeuro;

import com.goeuro.exception.NoInputException;
import com.goeuro.handler.CSVRequestHandler;
import com.goeuro.handler.RequestHandler;
import com.goeuro.request.Request;

public class EntryPoint 
{
    public static void main(String[] args)
    {
        EntryPoint entry = new EntryPoint();
        try {
        	Request request = new Request(args);
        	entry.getExportCityData(request);
        	System.out.println("The data has been exported to file "+request.getCityName()+"."+request.getOutputFormat());
		} catch (NoInputException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    public void getExportCityData(Request request) {
		if(request.getOutputFormat().equalsIgnoreCase("CSV")){
			RequestHandler requestHandler = new CSVRequestHandler();
			requestHandler.handleRequest(request);
		}
    }
}
