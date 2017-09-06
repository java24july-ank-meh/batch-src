package com.revature.customer.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.customer.model.Customer;

@RestController
public class CustomerController {
	
	private List<Customer> customers;
	
	public CustomerController() {
		customers = new LinkedList<>();
		customers.add(new Customer(1, "Tony", "Jenkins"));
		customers.add(new Customer(2, "Sombre", "Gonzales"));
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET, produces="application/json")
	public Customer getCustomer(@PathVariable int id) {
		Customer returnCustomer = null;
		for(Customer c : customers) {
			if (id == c.getId())
				returnCustomer = c;
		}
		return returnCustomer;
	}

}
