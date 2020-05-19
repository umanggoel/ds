package com.service.models;

public enum DaysEnum {

	MON(1) ,
	TUE(2),
	WED(3),
	THU(4),
	FRI(5),
	SAT(6),
	SUN(7);

	private int dayValue;
	private DaysEnum(int dayValue) {
		this.dayValue= dayValue; 
	}
	
	public int getDayValue() {
		return dayValue;
	}
	
	public DaysEnum getDays(int dayValue) {
		
		for(DaysEnum day: DaysEnum.values()) {
			if(day.getDayValue() == dayValue) {
				return day;
			}
		}
		
		return null;
	}
}

