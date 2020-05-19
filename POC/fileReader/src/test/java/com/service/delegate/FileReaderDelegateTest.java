package com.service.delegate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.service.models.FileResponseBean;
import com.service.service.FileReaderService;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FileReaderDelegateTest {

	@InjectMocks FileReaderDelegate delegate = new FileReaderDelegate();
	@Mock FileReaderService fileReaderService;
	
	@Test
	public void testopenHotels() {
		when(fileReaderService.getOpenHotels(Mockito.anyString(), Mockito.anyString())).thenReturn(new ArrayList<>());
		
		FileResponseBean response = delegate.getOpenHotels("london.csv", "2018-9-9 7:7");
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getHotels());
	}
}
