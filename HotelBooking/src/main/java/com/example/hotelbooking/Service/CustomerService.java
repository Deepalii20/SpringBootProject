package com.example.hotelbooking.Service;

import com.example.hotelbooking.Entity.Customer;

public interface CustomerService {
	
	 public String addCustomer(Customer c);
	 public String editCustomer(Customer c);
	public void validateCustomerExists(Long customerId);
	public Customer getCustomerById(Long customerId);

}
