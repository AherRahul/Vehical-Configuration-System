package com.freelance.training.vehicle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.freelance.training.vehicle.models.Customer;

/**
 * provides implementation of CRUD operations for customer table
 * @author rahul
 * 
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query( value = "SELECT * FROM customer c WHERE c.login_id=?1 and c.password=?2", nativeQuery = true)
	public List<Customer> findByLoginIdandPassword(String loginid,String password);

}
