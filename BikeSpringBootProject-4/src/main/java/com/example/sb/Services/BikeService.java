package com.example.sb.Services;

import java.util.List;

import com.example.sb.entities.Bike;

public interface BikeService {
	public String createBike(Bike b);
	public List<Bike> fetchAllBikes();
	public String updateBike(Bike b);
	public String deteleBike(String engNo);

}
