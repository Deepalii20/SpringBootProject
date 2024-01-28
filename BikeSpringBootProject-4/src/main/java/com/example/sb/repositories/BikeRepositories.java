package com.example.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb.entities.Bike;

public interface BikeRepositories extends JpaRepository<Bike, String> {

}
