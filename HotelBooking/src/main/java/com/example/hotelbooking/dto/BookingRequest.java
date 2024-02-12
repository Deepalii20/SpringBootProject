package com.example.hotelbooking.dto;

import java.util.Date;

public class BookingRequest {
	private Long roomId;
    private Long customerId;
    private String checkInDate;
    private String checkOutDate;
    private String status;
    private int totalprice;
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
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
	
	
	
	
	
	public BookingRequest(Long roomId, Long customerId, String checkInDate, String checkOutDate, String status,
			int totalprice) {
		super();
		this.roomId = roomId;
		this.customerId = customerId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.status = status;
		this.totalprice = totalprice;
		
	}
	public BookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
    

}
