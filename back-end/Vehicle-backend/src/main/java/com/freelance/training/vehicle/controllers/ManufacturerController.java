package com.freelance.training.vehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.training.vehicle.models.Manufacturer;
import com.freelance.training.vehicle.services.ManufacturerService;

/**
 * This class is responsible for the CRUD operations on manufacturer table in the database.
 * @author rahul
 * 
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin( origins = "http://localhost:4200")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manService;
	
	/**
	 * returns manufacturers from manufacturer table
	 * @return List<Manufacturer>
	 */
	@GetMapping("/manufacturers")
	public List<Manufacturer> list(){
		return manService.listAll();
	}
	
	

}
