package com.example.hotelbooking.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelbooking.Entity.Booking;
import com.example.hotelbooking.Entity.Room;
import com.example.hotelbooking.Repository.BookingRepository;
import com.example.hotelbooking.dto.BookingRequest;
import com.example.hotelbooking.exception.InvalidBookingException;
import com.example.hotelbooking.exception.ResourceNotFoundException;
import com.example.hotelbooking.exception.RoomUnavailableException;


@Service
public class BookingServiceImpl implements BookingService {

 @Autowired
 private BookingRepository bookingRepository;

 @Autowired
 private RoomService roomService;

 @Autowired
 private CustomerService customerService;

 @Override
 public Booking bookRoom(BookingRequest bookingRequest) throws RoomUnavailableException {
     
     validateBookingRequest(bookingRequest);
     Long roomId = bookingRequest.getRoomId();
     Long customerId = bookingRequest.getCustomerId();

     roomService.validateRoomExists(roomId);
     customerService.validateCustomerExists(customerId);
     Room room = roomService.getRoomById(roomId);
     

     
     roomService.validateRoomAvailability(roomId, bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());
     Booking room1 = bookingRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + roomId));
     int totalPrice = calculateTotalPrice(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate(), room.getPricePerDay());
    
     
     // Create and save the booking
     Booking booking = new Booking();
     booking.setRoom(roomService.getRoomById(roomId));
     booking.setCustomer(customerService.getCustomerById(customerId));
     booking.setCheckInDate(bookingRequest.getCheckInDate());
     
     booking.setCheckOutDate(bookingRequest.getCheckOutDate());
     booking.setTotalPrice(totalPrice); 
     booking.setStatus(bookingRequest.getStatus());
     return bookingRepository.save(booking);
     
 }

 



 private int calculateTotalPrice(String checkInDate, String checkOutDate, long pricePerDay) {
	    try {
	        // Parse the check-in and check-out dates
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date startDate = dateFormat.parse(checkInDate);
	        Date endDate = dateFormat.parse(checkOutDate);

	        // Calculate the duration in days
	        long duration = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);

	        // Calculate the total price
	        return (int) (pricePerDay * duration);
	    } catch (ParseException e) {
	        throw new InvalidBookingException("Invalid date format in the booking request.");
	    }
	}






//private int calculateTotalPrice(Long roomId, String checkInDate, String checkOutDate) {
	    
	//	int ratePerDay = 1000;  // Adjust this value based on your pricing strategy

	    // Parse the check-in and check-out dates
	  //  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    //try {
	      //  Date startDate = dateFormat.parse(checkInDate);
	        //Date endDate = dateFormat.parse(checkOutDate);

	        // Calculate the duration in days
	        //long duration = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);

	        // Calculate the total price and cast it to int
	        //return (int) (ratePerDay * duration);
	    //} catch (ParseException e) {
	      //  throw new InvalidBookingException("Invalid date format in the booking request.");
	    //}
	
 //}





private void validateBookingRequest(BookingRequest bookingRequest) {
     if (bookingRequest.getRoomId() == null || bookingRequest.getCustomerId() == null ||
             bookingRequest.getCheckInDate() == null || bookingRequest.getCheckOutDate() == null) {
         throw new InvalidBookingException("Booking request is missing required fields.");
     }

     
 }







 
}



