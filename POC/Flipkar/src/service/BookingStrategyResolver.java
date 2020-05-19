package service;

public class BookingStrategyResolver {
	
	public BookingStrategy resolveBookingStrategy(int start, int end) {
		return new PriceBasedBooking();
	}
	
}
