package com.example.hotelbooking.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hotelbooking.Entity.Booking;

@Repository
	public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query(value = "SELECT * FROM bookings b WHERE b.roomid = :roomId AND " +
	           "((b.checkindate >= :checkInDate AND b.checkindate <= :checkOutDate) OR " +
	           "(b.checkoutdate >= :checkInDate AND b.checkoutdate <= :checkOutDate))", nativeQuery = true)
	    List<Booking> findConflictingBookings(@Param("roomId") Long roomId,
	                                          @Param("checkInDate") String checkInDate,
	                                          @Param("checkOutDate") String checkOutDate);

	Booking save(String status);
	    
	}



