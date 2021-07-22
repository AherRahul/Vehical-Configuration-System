package com.freelance.training.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelance.training.vehicle.models.Manufacturer;

/**
 * provides implementation of CRUD operations for manufacturer table
 * @author rahul
 * 
 */
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>{

}
