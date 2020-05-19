package com.service.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.service.models.Hotel;
import com.service.models.TimeSlot;
import com.service.utils.Utils;

@Repository
public class ReadFileRepository {

	@Value("${csv.path}")
	private String csvPath;
	
	@Autowired
	Utils utils;
	
	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}

	@Cacheable(value="hotelsCache")
	public List<Hotel> getHotels(String fileName){
		
		List<Hotel> hotels = new ArrayList<>();
		
		String csvFile = csvPath + fileName;

        Scanner scanner;
		try {
			scanner = new Scanner(new File(csvFile));
			while (scanner.hasNext()) {
	            Hotel hotel = parseLine(scanner.nextLine());
	            hotels.add(hotel);
	        }
	        scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
		return hotels;
	}
	
	private Hotel parseLine(String line) {
		if(StringUtils.isEmpty(line)) {
			return null;
		}
		Hotel hotel = new Hotel();
		int splitIndex = line.indexOf(",");
		
		hotel.setName(line.substring(1, splitIndex-1));
		String timings[] = line.substring(splitIndex+2,line.length()-1).toUpperCase().split("/");
		Map<Integer, TimeSlot> timeSlots = new HashMap<>();
		for(int i=0;i< timings.length;i++) {
			String temp = timings[i].replaceAll(", ", ",");
			List<Integer> days = utils.calculateDays(temp.trim());
			TimeSlot slot = utils.calculateTimeSlot(temp.trim());
			days.forEach(day -> timeSlots.put(day, slot));
		}        
		
		hotel.setTimeSlotsMap(timeSlots);
		
		return hotel;
	}
}
