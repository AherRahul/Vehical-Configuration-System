package com.freelance.training.vehicle.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.training.vehicle.models.Manufacturer;
import com.freelance.training.vehicle.repositories.ManufacturerRepository;

/**
 * communicates with DAO layer to perform CRUD operations on manufacturer table
 * @author rahul
 *
 */
@Service
@Transactional
public class ManufacturerService {
	
	@Autowired
	private ManufacturerRepository manRepo;
	
	/**
	 * returns manufacturers from manufacturer table
	 * @return List<Manufacturer>
	 */
	public List<Manufacturer> listAll(){
		return manRepo.findAll();
	}

}
