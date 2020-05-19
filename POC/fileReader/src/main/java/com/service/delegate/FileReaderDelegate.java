package com.service.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.models.FileResponseBean;
import com.service.service.FileReaderService;

@Component
public class FileReaderDelegate {

	@Autowired FileReaderService service;
	
	public FileResponseBean getOpenHotels(String fileName, String date){
		FileResponseBean response = new FileResponseBean();
		response.setHotels(service.getOpenHotels(fileName, date));
		return response;
		
	}
}
