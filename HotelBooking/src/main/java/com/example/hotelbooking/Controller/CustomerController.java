package com.example.hotelbooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelbooking.Entity.Customer;
import com.example.hotelbooking.Service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService cms;
	
	@PostMapping("/add")
	public String addCustomer(@Valid @RequestBody Customer c) {
		return cms.addCustomer(c);
	}
	
	@PutMapping("/edit")
	public String editCustomer(@Valid @RequestBody Customer c) {
		return cms.editCustomer(c);
	}

}
