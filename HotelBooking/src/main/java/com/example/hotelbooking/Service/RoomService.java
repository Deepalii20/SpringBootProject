package com.example.hotelbooking.Service;

import java.util.Date;
import java.util.List;

import com.example.hotelbooking.Entity.Room;
import com.example.hotelbooking.dto.SearchAvailableRooms;

public interface RoomService {
	
	public String addRoom(Room r);
	public String editRoom(Room r);
	public List<Room> searchRooms(SearchAvailableRooms searchroom);
	public void validateRoomExists(Long roomId);
	
	public Room getRoomById(Long roomId);
	void validateRoomAvailability(Long roomId, String checkInDate, String checkOutDate);

}
