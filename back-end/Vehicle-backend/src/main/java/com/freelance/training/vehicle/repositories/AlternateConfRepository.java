package com.freelance.training.vehicle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.freelance.training.vehicle.models.AlternateConf;

/**
 * provides implementation of CRUD operations for alternate_conf table
 * @author rahul
 *   
 */
public interface AlternateConfRepository extends JpaRepository<AlternateConf, Long> {
	
	@Query( value = "SELECT * FROM alternate_conf a where a.conf_id=?1", nativeQuery = true)
	public List<AlternateConf> findByConfid(Long confid);

}
