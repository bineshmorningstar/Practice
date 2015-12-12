package com.goeuro.handler;

import com.goeuro.writer.CSVWriter;

public class CSVRequestHandler extends RequestHandler {

	@Override
	public void exportToFile(String cityName) {
		CSVWriter csvWriter = new CSVWriter(cityName);
		csvWriter.write(getCityData());
	}
	
}
