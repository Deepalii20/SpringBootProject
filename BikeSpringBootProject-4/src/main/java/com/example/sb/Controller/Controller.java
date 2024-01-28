package com.example.sb.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.Services.BikeService;
import com.example.sb.entities.Bike;

@RestController
@RequestMapping("bike")
public class Controller {
	BikeService bkservice;

	public Controller(BikeService bkservice) {
		super();
		this.bkservice = bkservice;
	}
	
	@PostMapping
	public String createBike(@RequestBody Bike b) {
		String msg = bkservice.createBike(b);
		return msg;
	}
	
	@GetMapping
	public List<Bike> fetchAllBikes(){
		List<Bike> bikeobj=bkservice.fetchAllBikes();
		return bikeobj;
	}
	
	@PutMapping
	public String updateBike(@RequestBody Bike b) {
		String msg=bkservice.updateBike(b);
		return msg;
	}
	
	@DeleteMapping("{engNo}")
	public String deteleBike(@PathVariable String engNo) {
		String msg=bkservice.deteleBike(engNo);
		return msg;
	}
}
	