package com.freelance.training.vehicle.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.training.vehicle.models.Segment;
import com.freelance.training.vehicle.repositories.SegmentRepository;

/**
 * communicates with DAO layer to perform CRUD operations on segment table
 * @author rahul
 *
 */
@Service
@Transactional
public class SegmentService {
	
	@Autowired
	private SegmentRepository segmentRepo;
	
	/**
	 * returns segments from segment table
	 * @return List<Segment>
	 */
	public List<Segment> listAll(){
		return segmentRepo.findAll();
	}

}
