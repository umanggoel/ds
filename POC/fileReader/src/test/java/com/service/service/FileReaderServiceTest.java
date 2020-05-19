package com.service.service;

import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.service.models.Hotel;
import com.service.models.TimeSlot;
import com.service.repository.ReadFileRepository;

@RunWith(MockitoJUnitRunner.class)
public class FileReaderServiceTest {

	@InjectMocks
	FileReaderService service = new FileReaderService();
	@Mock
	ReadFileRepository readFileRepository; 
	
	
	static List<Hotel> hotelsSampleData = new ArrayList<>();
	
//	"Hennessy Pub","Mon,Tues,Sun 11:30 am - 2 am"

	@BeforeClass
	public static void setup() {
		Hotel hotel = new Hotel();
		hotel.setName("Hennessy Pub");
		final DateFormat formatDate = new SimpleDateFormat("hh:mm a");
		TimeSlot slot = new TimeSlot();
		try {
			slot.setEndTime((Date)formatDate.parse("2:00 am"));
			slot.setStartTime((Date)formatDate.parse("11:30 am"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Map<Integer, TimeSlot> timeSlots = new HashMap<>(); 
		timeSlots.put(1, slot);
		timeSlots.put(2, slot);
		timeSlots.put(7, slot);
		hotel.setTimeSlotsMap(timeSlots);
		
		hotelsSampleData.add(hotel);
		
	}
	
	@Test
	public void noHotelAvailableInFile() {
		when(readFileRepository.getHotels(Mockito.anyString())).thenReturn(new ArrayList<>());
		List<String> hotels = service.getOpenHotels("test1.csv", "2018-09-09 12:12");
		Assert.assertNotNull(hotels);
		Assert.assertEquals(0, hotels.size());
	}

	@Test
	public void testForInputDateofSunday() {
		when(readFileRepository.getHotels(Mockito.anyString())).thenReturn(hotelsSampleData);
		List<String> hotels = service.getOpenHotels("test1.csv", "2018-09-09 12:12");
		Assert.assertNotNull(hotels);
		Assert.assertEquals(1, hotels.size());

	}

	@Test
	public void testForInputDateofNonSunday() {
		when(readFileRepository.getHotels(Mockito.anyString())).thenReturn(hotelsSampleData);
		List<String> hotels = service.getOpenHotels("test1.csv", "2018-09-11 12:12");
		Assert.assertNotNull(hotels);
		Assert.assertEquals(1, hotels.size());
	}

	@Test
	public void testForOpenHotelAfterMidnightForHotelOpenInMidnight() {
		when(readFileRepository.getHotels(Mockito.anyString())).thenReturn(hotelsSampleData);
		List<String> hotels = service.getOpenHotels("test1.csv", "2018-09-09 12:12");
		Assert.assertNotNull(hotels);
		Assert.assertEquals(1, hotels.size());

	}

	@Test
	public void testForOpenHotelBeforeMidnightForHotelOpenInMidnight() {
		when(readFileRepository.getHotels(Mockito.anyString())).thenReturn(hotelsSampleData);
		List<String> hotels = service.getOpenHotels("test1.csv", "2018-09-09 21:12");
		Assert.assertNotNull(hotels);
		Assert.assertEquals(1, hotels.size());
	}

	@Test
	public void testForHotelNotOpenOnSomeDay() {
		when(readFileRepository.getHotels(Mockito.anyString())).thenReturn(hotelsSampleData);
		List<String> hotels = service.getOpenHotels("test1.csv", "2018-09-08 12:12");
		Assert.assertNotNull(hotels);
		Assert.assertEquals(0, hotels.size());
	}

	@Test
	public void testForHotelNotOpenOnTimeBeforetheStartTime() {
		when(readFileRepository.getHotels(Mockito.anyString())).thenReturn(hotelsSampleData);
		List<String> hotels = service.getOpenHotels("test1.csv", "2018-09-09 10:12");
		Assert.assertNotNull(hotels);
		Assert.assertEquals(0, hotels.size());
	}

	@Test
	public void testForHotelNotOpenOnTimeAftertheStartTime() {
		when(readFileRepository.getHotels(Mockito.anyString())).thenReturn(hotelsSampleData);
		List<String> hotels = service.getOpenHotels("test1.csv", "2018-09-09 4:12");
		Assert.assertNotNull(hotels);
		Assert.assertEquals(0, hotels.size());
	}

}
