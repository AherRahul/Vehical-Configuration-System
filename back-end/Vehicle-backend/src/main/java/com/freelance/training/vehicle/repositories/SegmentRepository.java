package com.freelance.training.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelance.training.vehicle.models.Segment;

/**
 * provides implementation of CRUD operations for segment table
 * @author rahul
 * 
 */
public interface SegmentRepository extends JpaRepository<Segment, Long> {

}
