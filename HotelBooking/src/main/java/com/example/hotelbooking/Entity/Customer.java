package com.example.hotelbooking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="customers")
public class Customer {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "customerid")
	    private Long customerId;

	    @Column(name = "firstname")
	    @NotEmpty(message = "First name cannot be empty")
	    private String firstName;

	    @Column(name = "lastname")
	    private String lastName;

	    @Column(name = "email")
	    @Email(message = "give valid email id")
	    private String email;

	    @Column(name = "phone")
	    @Pattern(regexp = "^\\d{10}$")
	    private String phone;

	    @Column(name = "location")
	    @NotEmpty(message = "location cant be null")
	    private String location;

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public Customer(Long customerId, String firstName, String lastName, String email, String phone,
				String location) {
			super();
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phone = phone;
			this.location = location;
		}

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
	    


}
