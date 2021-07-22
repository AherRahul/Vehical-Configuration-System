package com.freelance.training.vehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.training.vehicle.models.AlternateConf;
import com.freelance.training.vehicle.services.AlternateConfService;

/**
 * This class is responsible for the CRUD operations on alternate_conf table in the database.
 * @author rahul
 * 
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin( origins = "http://localhost:4200")
public class AlternateConfController {
	
	@Autowired
	private AlternateConfService altService;
	
	/**
	 * returns all alternate configurations from alternate_conf table
	 * @return List<AlternateConf>
	 */
	@GetMapping("/alternateconfs")
	public List<AlternateConf> list(){
		return altService.listAll();
	}
	
	/**
	 * return alternate configurations from alternate_conf table for the particular configuration
	 * @param confid
	 * @return List<AlternateConf>
	 */
	@GetMapping("/alternateconfs/{confid}")
	public List<AlternateConf> listByConfid(@PathVariable String confid){
		return altService.listAllByConfid(confid);
	}

}
