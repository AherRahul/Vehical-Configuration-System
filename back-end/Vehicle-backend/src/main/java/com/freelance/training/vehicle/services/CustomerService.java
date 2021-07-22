package com.freelance.training.vehicle.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.training.vehicle.models.Customer;
import com.freelance.training.vehicle.repositories.CustomerRepository;

/**
 * communicates with DAO layer to perform CRUD operations on customer table
 * @author rahul
 *
 */
@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	/**
	 * returns customers from customer table
	 * @return List<Customer>
	 */
	public List<Customer> listAll(){
		return customerRepo.findAll();
	}
	
	/**
	 * persists the customer into database and returns that customer instance
	 * @param customer
	 * @return Customer
	 */
	public Customer add(Customer customer) {
		return customerRepo.saveAndFlush(customer);
	}
	
	/**
	 * 
	 * checks the given login_id and password present in the customer table of the database
	 * return comapny_id if present else 0 
	 * @param loginid
	 * @param password
	 * @return String comapny_id/0
	 */
	public String checkLoginCredentials(String loginid, String password) {
		List<Customer> customers = customerRepo.findByLoginIdandPassword(loginid, password);
		if (customers.size() > 0)
			return customers.get(0).getCompany_id().toString();
		else
			return "0";
	}
	
	/**
	 * returns a particular customer by using company_id
	 * @param companyId
	 * @return Customer
	 */
	public Optional<Customer> findById(String companyId) {
		return customerRepo.findById(Long.parseLong(companyId));
	}
}
