package com.example.hotelbooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelbooking.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
