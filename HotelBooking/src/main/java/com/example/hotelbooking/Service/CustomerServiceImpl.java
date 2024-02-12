package com.example.hotelbooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelbooking.Entity.Customer;
import com.example.hotelbooking.Repository.CustomerRepository;
import com.example.hotelbooking.exception.CustomerNotFoundException;
import com.example.hotelbooking.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository cmr;

	@Override
	public String addCustomer(Customer c) {
		cmr.save(c);
		return "Customer is added";
	}

	@Override
	public String editCustomer(Customer c) {
		cmr.save(c);
		return "Customer details are edited";
	}

	@Override
	public void validateCustomerExists( Long customerId) {
		 if (!cmr.existsById(customerId)) {
	            throw new CustomerNotFoundException("Customer not found with id: " + customerId);
	        }
		
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return cmr.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));
	}

}
