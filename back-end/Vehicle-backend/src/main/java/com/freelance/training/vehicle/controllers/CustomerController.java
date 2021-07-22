package com.freelance.training.vehicle.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.training.vehicle.models.Customer;
import com.freelance.training.vehicle.services.CustomerService;

/**
 * This class is responsible for the CRUD operations on customers table in the database.
 * @author rahul
 * 
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin( origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * returns customers from customer table
	 * @return List<Customer>
	 */
	@GetMapping("/customers")
	public List<Customer> list(){
		return customerService.listAll();
	}
	
	/**
	 * persists the customer into database and returns that customer
	 * @param customer
	 * @return Customer
	 */
	@PostMapping("/register")
	public Customer register(@RequestBody Customer customer) {
		return customerService.add(customer);
	}
	
	/**
	 * 
	 * checks the given login_id and password present in the customer table of the database
	 * return comapny_id if present else 0 
	 * @param loginid
	 * @param password
	 * @return String comapny_id/0
	 */
	@GetMapping("/check/{loginid}/{password}")
	public String checkCredentials(@PathVariable String loginid,@PathVariable String password) {
		return customerService.checkLoginCredentials(loginid, password);
	}
	
	/**
	 * returns a particular customer by using company_id
	 * @param companyId
	 * @return Customer
	 */
	@GetMapping("/customer/{companyid}")
	public Optional<Customer> getCustomer(@PathVariable String companyid) {
		return customerService.findById(companyid);
	}

}
