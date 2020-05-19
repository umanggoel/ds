package com.service.controller;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.service.delegate.FileReaderDelegate;
import com.service.models.FileResponseBean;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FileReaderControllerTest {
	
	@InjectMocks FileReaderController controller = new FileReaderController();
	@Mock FileReaderDelegate fileReaderDelegate;
	
	@Test
	public void testListOfopenHotels() {
		
	 when(fileReaderDelegate.getOpenHotels(Mockito.anyString(), Mockito.anyString())).thenReturn(new FileResponseBean());
	 ResponseEntity<FileResponseBean> response = controller.getOpenHotels("london_poi.csv", "2018-07-12 11:23");
	 Assert.assertNotNull(response);
	 
	}
}
