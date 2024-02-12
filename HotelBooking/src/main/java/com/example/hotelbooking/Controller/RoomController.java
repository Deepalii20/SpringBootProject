package com.example.hotelbooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelbooking.Entity.Room;
import com.example.hotelbooking.Service.RoomService;
import com.example.hotelbooking.dto.SearchAvailableRooms;
import com.example.hotelbooking.exception.RoomUnavailableException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/room")
public class RoomController {
	
	@Autowired
	RoomService rms;
	
	@PostMapping("/add")
	public String addRoom(@Valid @RequestBody Room r) {
		return rms.addRoom(r);
	}
	@PutMapping("/edit")
	public String editRoom(@Valid @RequestBody Room r) {
		return rms.editRoom(r);
		
	}
	@PostMapping("/search")
    public List<Room> searchRooms(@Valid @RequestBody SearchAvailableRooms searchroom) {
        try {
            return rms.searchRooms(searchroom);
        } catch (RoomUnavailableException e) {
            throw new RoomUnavailableException(e.getMessage());
        }

	}
}
