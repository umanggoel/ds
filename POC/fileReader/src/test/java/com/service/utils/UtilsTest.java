package com.service.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.service.models.TimeSlot;

@RunWith(MockitoJUnitRunner.class)
public class UtilsTest {

	@InjectMocks
	Utils utils = new Utils();

	DateFormat formatter1 = new SimpleDateFormat("hh:mm a");
	DateFormat formatter2 = new SimpleDateFormat("hh a");

	@Test
	public void calucateTimeSlotForNullEnty() {
		TimeSlot slot = utils.calculateTimeSlot(null);
		Assert.assertNull(slot);
	}

	@Test
	public void calucateDaysForNullEnty() {
		List<Integer> slot = utils.calculateDays(null);
		Assert.assertNull(slot);
	}

	// format1 = DateFormat formatter1 = new SimpleDateFormat("hh:mm a");
	@Test
	public void calucateTimeSlotForFormat1Ofdateformat() throws Exception{
		TimeSlot slot = utils.calculateTimeSlot("Mon-Sun 11:30 am - 9:00 pm");
		Date expectedStartDate = (Date) formatter1.parse("11:30 am");
		Date expectedEndDate = (Date) formatter1.parse("9:00 pm");
		Assert.assertNotNull(slot);
		Assert.assertTrue(expectedStartDate.compareTo(slot.getStartTime()) == 0);
		Assert.assertTrue(expectedEndDate.compareTo(slot.getEndTime()) == 0);

	}

	// format2 = DateFormat formatter2 = new SimpleDateFormat("hh a");
	@Test
	public void calucateTimeSlotForFormat2Ofdateformat() throws Exception{
		TimeSlot slot = utils.calculateTimeSlot("Mon-Sun 11 am - 9 pm");
		Assert.assertNotNull(slot);
		Date expectedStartDate = (Date) formatter2.parse("11 am");
		Date expectedEndDate = (Date) formatter2.parse("9 pm");

		Assert.assertTrue(expectedStartDate.compareTo(slot.getStartTime()) == 0);
		Assert.assertTrue(expectedEndDate.compareTo(slot.getEndTime()) == 0);


	}

	@Test
	public void calucateDaysForValidInputAllDays() {
		List<Integer> days = utils.calculateDays("Mon-Sun 11:30 am - 9:00 pm");
		Assert.assertNotNull(days);
		Assert.assertTrue(days.contains(2));

	}

	@Test
	public void calucateDaysForValidInputFewDays() {
		List<Integer> days = utils.calculateDays("Mon-Tue,Sat 11:30 am - 9:00 pm");
		Assert.assertNotNull(days);
		Assert.assertTrue(days.contains(2));
		Assert.assertFalse(days.contains(3));
	}
}
