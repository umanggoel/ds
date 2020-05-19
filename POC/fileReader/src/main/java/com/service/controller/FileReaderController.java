package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.delegate.FileReaderDelegate;
import com.service.models.FileResponseBean;

@RestController
public class FileReaderController {
	
	@Autowired  FileReaderDelegate fileReaderDelegate;

    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<FileResponseBean> getOpenHotels(
    		@RequestParam(required=true) String fileName,
    		@RequestParam(required=true) String date
    		) {
    		
        return new ResponseEntity<>(fileReaderDelegate.getOpenHotels(fileName, date),HttpStatus.OK);
    }

}