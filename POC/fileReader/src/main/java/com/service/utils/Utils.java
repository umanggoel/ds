package com.service.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.service.models.DaysEnum;
import com.service.models.TimeSlot;

@Component
public class Utils {

	public TimeSlot calculateTimeSlot(String entry) {
		if(entry == null) {
			return null;
		}
		
		String dataSet = entry.toUpperCase();
		int end = dataSet.indexOf(" ");
		String slots[] = dataSet.substring(end).split("-");
		DateFormat formatter1 = new SimpleDateFormat("hh:mm a");
		DateFormat formatter2 = new SimpleDateFormat("hh a");
		String timeRegex1 = "[0-9]{1,2}:[0-9]{1,2}\\s[P|A]M";
		
		TimeSlot slot = new TimeSlot();
		try {
			if(slots[0].trim().matches(timeRegex1)) {
				slot.setStartTime((Date)formatter1.parse(slots[0].trim()));
			}else {
				slot.setStartTime((Date)formatter2.parse(slots[0].trim()));
			}
			
			if(slots[1].trim().matches(timeRegex1)) {
				slot.setEndTime((Date)formatter1.parse(slots[1].trim()));
			}else {
				slot.setEndTime((Date)formatter2.parse(slots[1].trim()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return slot;
	}

	public List<Integer> calculateDays(String entry) {
		if(entry == null) {
			return null;
		}
		
		String dataSet = entry.toUpperCase();
		int end = dataSet.indexOf(" ");
		List<Integer> result = new ArrayList<>(7);
		String days[] = dataSet.substring(0,end).split(",");

		for(int i=0; i< days.length ;i++) {
			if(days[i].indexOf("-") > 0) {
				String tempDays[] = days[i].split("-");
				int startDay = DaysEnum.valueOf(tempDays[0].trim()).getDayValue();
				int endDay = DaysEnum.valueOf(tempDays[1].trim()).getDayValue();
				for(int j=startDay ; j <= endDay ; j++) {
					result.add(j);
				}
			} else {
				result.add(DaysEnum.valueOf(days[i].trim()).getDayValue()); 
			}
		}
		return result;
	}
}
