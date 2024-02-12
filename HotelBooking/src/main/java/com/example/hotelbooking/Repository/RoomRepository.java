package com.example.hotelbooking.Repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hotelbooking.Entity.Room;
import com.example.hotelbooking.enums.RoomType;


public interface RoomRepository extends JpaRepository<Room, Long> {
	
	@Query("SELECT r FROM Room r WHERE r.roomType = :roomType " +
            "AND r.roomId NOT IN (" +
            "   SELECT b.room.roomId " +
            "   FROM Booking b " +
            "   WHERE (b.checkInDate BETWEEN :checkInDate AND :checkOutDate) " +
            "      OR (b.checkOutDate BETWEEN :checkInDate AND :checkOutDate)" +
            ")")
    List<Room> searchAvailableRooms(
            @Param("roomType") String roomType,
            @Param("checkInDate") String checkInDate,
            @Param("checkOutDate") String checkOutDate);
}

	


