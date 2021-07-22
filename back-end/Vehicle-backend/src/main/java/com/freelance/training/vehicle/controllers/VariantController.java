package com.freelance.training.vehicle.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.training.vehicle.models.Variant;
import com.freelance.training.vehicle.services.VariantService;

/**
 * This class is responsible for the CRUD operations on variant table in the database.
 * @author rahul
 * 
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin( origins = "http://localhost:4200")
public class VariantController {
	
	@Autowired
	private VariantService variantService;
	
	/**
	 * returns variants from variant table
	 * @return List<Variant>
	 */
	@GetMapping("/variants")
	public List<Variant> list(){
		return variantService.listAll();
	}
	
	/**
	 * returns variants which are belongs to particular segment and manufacturer
	 * @param segid
	 * @param manid
	 * @return List<Variant>
	 */
	@GetMapping("/variants/{segid}/{manid}")
	public List<Variant> listBySegidAndManid(@PathVariable String segid,@PathVariable String manid){
		return variantService.listBySegidAndManid(segid,manid);
	}
	
	/**
	 * returns variant details based on the var_id
	 * @param varid
	 * @return Variant
	 */
	@GetMapping("/variants/{varid}")
	public Optional<Variant> getVariant(@PathVariable String varid) {
		return variantService.getVariant(varid);
	}

}
