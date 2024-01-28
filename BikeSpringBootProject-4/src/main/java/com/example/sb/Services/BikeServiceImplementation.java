package com.example.sb.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sb.entities.Bike;
import com.example.sb.repositories.BikeRepositories;

@Service
public class BikeServiceImplementation implements BikeService {
	BikeRepositories bkrepo;
	public BikeServiceImplementation(BikeRepositories bkrepo) {
		super();
		this.bkrepo = bkrepo;
	}

	

	@Override
	public String createBike(Bike b) {
		bkrepo.save(b);
		return "Bike object is created and saved";
	}

	@Override
	public List<Bike> fetchAllBikes() {
		List<Bike> bikelist= bkrepo.findAll();
		return bikelist;
	}

	@Override
	public String updateBike(Bike b) {
		bkrepo.save(b);
		return "Bike object is updated";
	}

	@Override
	public String deteleBike(String engNo) {
		bkrepo.deleteById(engNo);
		return "Bike object is deleted";
	}
	
	

}
