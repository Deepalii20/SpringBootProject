package com.example.hotelbooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelbooking.Entity.Booking;
import com.example.hotelbooking.Repository.BookingRepository;
import com.example.hotelbooking.Service.BookingService;
import com.example.hotelbooking.dto.BookingRequest;
import com.example.hotelbooking.exception.ResourceNotFoundException;
import com.example.hotelbooking.exception.RoomUnavailableException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    
    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("/book")
    public ResponseEntity<String> bookRoom(@Valid @RequestBody BookingRequest bookingRequest) {
        try {
            Booking bookedRoom = bookingService.bookRoom(bookingRequest);
            return ResponseEntity.ok("Room booked successfully. Booking ID: " + bookedRoom.getBookingId() +
                    ". Total Price: " + bookedRoom.getTotalPrice());
        } catch (RoomUnavailableException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        
    }
    

    }

