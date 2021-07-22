package com.freelance.training.vehicle.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.training.vehicle.models.AlternateConf;
import com.freelance.training.vehicle.repositories.AlternateConfRepository;

/**
 * communicates with DAO layer to perform CRUD operations on alternate_conf table
 * @author rahul
 *
 */
@Service
@Transactional
public class AlternateConfService {
	
	@Autowired
	private AlternateConfRepository altRepo;
	
	/**
	 * returns alternate configurations from alternate_conf table
	 * @return List<AlternateConf>
	 */
	public List<AlternateConf> listAll(){
		return altRepo.findAll();
	}
	
	
	/**
	 * return alternate configurations from alternate_conf table for the particular configuration
	 * @param confid
	 * @return List<AlternateConf>
	 */
	public List<AlternateConf> listAllByConfid(String confid){
		return altRepo.findByConfid(Long.parseLong(confid));
	}

}
