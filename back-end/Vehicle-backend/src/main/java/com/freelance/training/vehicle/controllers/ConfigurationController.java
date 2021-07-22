package com.freelance.training.vehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.training.vehicle.models.Configuration;
import com.freelance.training.vehicle.services.ConfigurationService;

/**
 * This class is responsible for the CRUD operations on configuration table in the database.
 * @author rahul
 *
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin( origins = "http://localhost:4200")
public class ConfigurationController {
	
	@Autowired
	private ConfigurationService confService;
	
	/**
	 * returns all configurations from configuration table
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations")
	public List<Configuration> list(){
		return confService.listAll();
	}
	
	/**
	 * returns configurations for the particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/{varid}")
	public List<Configuration> listByVarId(@PathVariable String varid){
		return confService.listAllByVarId(varid);
	}
	
	/**
	 * returns default configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/default/{varid}")
	public List<Configuration> listDefaultByVarid(@PathVariable String varid){
		return confService.listDefaultByVarid(varid);
	}
	
	/**
	 * returns interior configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/interior/{varid}")
	public List<Configuration> listInteriorByVarid(@PathVariable String varid){
		return confService.listInteriorByVarid(varid);
	}
	
	/**
	 * returns exterior configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/exterior/{varid}")
	public List<Configuration> listExteriorByVarid(@PathVariable String varid){
		return confService.listExteriorByVarid(varid);
	}
	
	/**
	 * returns accessories configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/accessories/{varid}")
	public List<Configuration> listAccessoriesByVarid(@PathVariable String varid){
		return confService.listAccessoriesByVarid(varid);
	}
	
	/**
	 * returns default configurable configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/default/configurable/{varid}")
	public List<Configuration> listDefaultConfigurableByVarid(@PathVariable String varid){
		return confService.listDefaultConfigurableByVarid(varid);
	}
	
	/**
	 * returns interior configurable configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/interior/configurable/{varid}")
	public List<Configuration> listInteriorConfigurableByVarid(@PathVariable String varid){
		return confService.listInteriorConfigurableByVarid(varid);
	}
	
	/**
	 * returns exterior configurable configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/exterior/configurable/{varid}")
	public List<Configuration> listExteriorConfigurableByVarid(@PathVariable String varid){
		return confService.listExteriorConfigurableByVarid(varid);
	}
	
	/**
	 * returns accessories configurable configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	@GetMapping("/configurations/accessories/configurable/{varid}")
	public List<Configuration> listAccessoriesConfigurableByVarid(@PathVariable String varid){
		return confService.listAccessoriesConfigurableByVarid(varid);
	}

}
