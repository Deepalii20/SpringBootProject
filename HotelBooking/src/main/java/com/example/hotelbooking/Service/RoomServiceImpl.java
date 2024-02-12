package com.example.hotelbooking.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelbooking.Entity.Booking;
import com.example.hotelbooking.Entity.Room;
import com.example.hotelbooking.Repository.BookingRepository;
import com.example.hotelbooking.Repository.RoomRepository;
import com.example.hotelbooking.dto.SearchAvailableRooms;
import com.example.hotelbooking.exception.ResourceNotFoundException;
import com.example.hotelbooking.exception.RoomUnavailableException;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	RoomRepository rmr;
	
	@Autowired
	BookingRepository brepo;

	@Override
	public String addRoom(Room r) {
		rmr.save(r);
		return "Room is added";
	}

	@Override
	public String editRoom(Room r) {
		rmr.save(r);
		return "Room details are updated";
	}

	@Override
	public List<Room> searchRooms(SearchAvailableRooms searchroom) {
		String checkInDate = searchroom.getCheckInDate();
        String checkOutDate = searchroom.getCheckOutDate();
        String roomType = searchroom.getRoomType();
        

        
        List<Room> availableRooms = rmr.searchAvailableRooms(roomType,checkInDate, checkOutDate);

        if (availableRooms.isEmpty()) {
            throw new RoomUnavailableException("No available rooms of type " + roomType +
                    " for the specified dates: " + checkInDate + " to " + checkOutDate);
        }

        return availableRooms;
    }

	@Override
	public void validateRoomExists(Long roomId) {
		if (!rmr.existsById(roomId)) {
            throw new ResourceNotFoundException("Room not found with id: " + roomId);
        }
		
	}

	
		
	

	@Override
	public Room getRoomById(Long roomId) {
		return rmr.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + roomId));
	}

	@Override
	public void validateRoomAvailability(Long roomId, String checkInDate, String checkOutDate) {
		List<Booking> conflictingBookings = brepo.findConflictingBookings(roomId, checkInDate, checkOutDate);
        if (!conflictingBookings.isEmpty()) {
            throw new RoomUnavailableException("Room is not available for the specified dates.");
        }
		
	}

	
	
        
	

}
