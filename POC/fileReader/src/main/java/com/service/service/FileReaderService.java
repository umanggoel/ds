package com.service.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.models.Hotel;
import com.service.models.TimeSlot;
import com.service.repository.ReadFileRepository;

@Service
public class FileReaderService {

	@Autowired ReadFileRepository readFileRepository;
	final DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	final DateFormat formatTime = new SimpleDateFormat("HH:mm");
	
	public List<String> getOpenHotels(String fileName, String date) {
		List<Hotel> hotels = readFileRepository.getHotels(fileName);
		return filterOpenHotels(hotels,date);
	}

	private List<String> filterOpenHotels(List<Hotel> hotels,String dateFilter){
		List<String> openHotels = new ArrayList<>();
		Date filter;
		try {
			filter = (Date)formatDate.parse(dateFilter.trim());
			int filterDay = filter.getDay() == 0?7:filter.getDay();
			Integer hours = filter.getHours();
			Integer min = filter.getMinutes();
			Date filterTime = (Date)formatTime.parse(hours.toString()+":"+min.toString());
			for(Hotel hotel: hotels) {
				if(isOpen(hotel, filterDay, filterTime)) {
					openHotels.add(hotel.getName());
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return openHotels;
	}
	
	private boolean isOpen(Hotel hotel,int filterDay,Date filterTime) throws ParseException {
		TimeSlot timeSlot =  hotel.getTimeSlotsMap().get(filterDay);
		final Date startTimeofDay =  (Date)formatTime.parse("00:00");
		final Date endTimeofDay = (Date)formatTime.parse("23:59");
		
		if(timeSlot == null) {
			return false;
		}else if(timeSlot.getStartTime().after(timeSlot.getEndTime())){
			if(filterTime.after(timeSlot.getStartTime()) && filterTime.before(endTimeofDay) ||
					filterTime.after(startTimeofDay) && filterTime.before(timeSlot.getEndTime())) {
				return true;
			}
		}else if(filterTime.after(timeSlot.getStartTime()) && filterTime.before(timeSlot.getEndTime())) {
			return true;
		}
		
		return false;
	}
}
