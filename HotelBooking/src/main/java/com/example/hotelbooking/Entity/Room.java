package com.example.hotelbooking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roomid")
	private Long roomId;
	
    @Column(name="hotelname")
    @NotEmpty(message="Hotel name cannot be null")
    private String hotelName;
    
    
    @Column(name="roomtype")
    @NotNull
    private String roomType;
    
    @Column(name="priceperday")
    @NotNull
    private long pricePerDay;
    
    
    @Column(name="maxoccupancy")
    @NotNull
    private int maxOccupancy;
    
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public long getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(long pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public int getMaxOccupancy() {
		return maxOccupancy;
	}
	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	public Room(Long roomId, String hotelName, String roomType, long pricePerDay, int maxOccupancy) {
		super();
		this.roomId = roomId;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.pricePerDay = pricePerDay;
		this.maxOccupancy = maxOccupancy;
	}
	public Room() {
		super();
		
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", hotelName=" + hotelName + ", roomType=" + roomType + ", pricePerDay="
				+ pricePerDay + ", maxOccupancy=" + maxOccupancy + "]";
	}
    


}
