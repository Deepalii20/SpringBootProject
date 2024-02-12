
package com.example.hotelbooking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "bookings")
public class Booking {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "bookingid")
 
 private Long bookingId;

 @ManyToOne
 @JoinColumn(name = "roomid")
 private Room room;

 @ManyToOne
 @JoinColumn(name = "customerid")
 private Customer customer;

 @Column(name = "checkindate")
 private String checkInDate;

 @Column(name = "checkoutdate")
 private String checkOutDate;

 @Column(name = "totalprice")
 private int totalPrice;

 @Column(name = "status")
 
 private String status;

 

 
 public Booking() {
     
 }

 public Booking(Room room, Customer customer, String checkInDate, String checkOutDate, int totalPrice, String status) {
     this.room = room;
     this.customer = customer;
     this.checkInDate = checkInDate;
     this.checkOutDate = checkOutDate;
     this.totalPrice = totalPrice;
     this.status = status;
 }

 

 public Long getBookingId() {
     return bookingId;
 }

 public void setBookingId(Long bookingId) {
     this.bookingId = bookingId;
 }

 public Room getRoom() {
     return room;
 }

 public void setRoom(Room room) {
     this.room = room;
 }

 public Customer getCustomer() {
     return customer;
 }

 public void setCustomer(Customer customer) {
     this.customer = customer;
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

 public int getTotalPrice() {
     return totalPrice;
 }

 public void setTotalPrice(int totalPrice) {
     this.totalPrice = totalPrice;
 }

 public String getStatus() {
     return status;
 }

 public void setStatus(String status) {
     this.status = status;
 }




}
