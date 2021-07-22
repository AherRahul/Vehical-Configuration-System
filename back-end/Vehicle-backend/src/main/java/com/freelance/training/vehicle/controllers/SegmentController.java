package com.freelance.training.vehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.training.vehicle.models.Segment;
import com.freelance.training.vehicle.services.SegmentService;

/**
 * This class is responsible for the CRUD operations on segment table in the database.
 * @author rahul
 * 
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin( origins = "http://localhost:4200")
public class SegmentController {
	
	@Autowired
	private SegmentService segmentService;
	
	/**
	 * returns segments from segment table
	 * @return List<Segment>
	 */
	@GetMapping("/segments")
	public List<Segment> list(){
		return segmentService.listAll();
	}

}
