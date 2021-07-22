package com.freelance.training.vehicle.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.training.vehicle.models.Configuration;
import com.freelance.training.vehicle.repositories.ConfigurationRepository;

/**
 * communicates with DAO layer to perform CRUD operations on configuration table
 * @author rahul
 *
 */
@Service
@Transactional
public class ConfigurationService {
	
	@Autowired
	private ConfigurationRepository confRepo;
	
	/**
	 * returns all configurations from configuration table
	 * @return List<Configuration>
	 */
	public List<Configuration> listAll(){
		return confRepo.findAll();
	}
	
	/**
	 * returns configurations for the particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listAllByVarId(String varid){
		return confRepo.findByVarId(Long.parseLong(varid));
	}
	
	/**
	 * returns default configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listDefaultByVarid(String varid){
		return confRepo.findDefaultByVarid(Long.parseLong(varid));
	}
	
	/**
	 * returns interior configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listInteriorByVarid(String varid){
		return confRepo.findInteriorByVarid(Long.parseLong(varid));
	}
	
	/**
	 * returns exterior configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listExteriorByVarid(String varid){
		return confRepo.findExteriorByVarid(Long.parseLong(varid));
	}
	
	/**
	 * returns accessories configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listAccessoriesByVarid(String varid){
		return confRepo.findAccessoriesByVarid(Long.parseLong(varid));
	}
	
	/**
	 * returns default configurable configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listDefaultConfigurableByVarid(String varid){
		return confRepo.findDefaultConfigurableByVarid(Long.parseLong(varid));
	}
	
	/**
	 * returns internal configurable configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listInteriorConfigurableByVarid(String varid){
		return confRepo.findInteriorConfigurableByVarid(Long.parseLong(varid));
	}
	
	/**
	 * returns external configurable configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listExteriorConfigurableByVarid(String varid){
		return confRepo.findExteriorConfigurableByVarid(Long.parseLong(varid));
	}
	
	/**
	 * returns accessories configurable configurations for particular variant
	 * @param varid
	 * @return List<Configuration>
	 */
	public List<Configuration> listAccessoriesConfigurableByVarid(String varid){
		return confRepo.findAccessoriesConfigurableByVarid(Long.parseLong(varid));
	}

}
