package com.example.hotelbooking.Service;

import com.example.hotelbooking.Entity.Booking;
import com.example.hotelbooking.dto.BookingRequest;
import com.example.hotelbooking.exception.InvalidBookingException;
import com.example.hotelbooking.exception.RoomUnavailableException;

public interface BookingService {
	 Booking bookRoom(BookingRequest bookingRequest) throws RoomUnavailableException, InvalidBookingException;

	
	
	

}
