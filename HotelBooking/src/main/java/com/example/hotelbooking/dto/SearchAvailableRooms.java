package com.example.hotelbooking.dto;

import java.util.Date;

public class SearchAvailableRooms {
	private String checkInDate;
    private String checkOutDate;
    private String roomType;
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public SearchAvailableRooms(String checkInDate, String checkOutDate, String roomType) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
	}
	public SearchAvailableRooms() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
