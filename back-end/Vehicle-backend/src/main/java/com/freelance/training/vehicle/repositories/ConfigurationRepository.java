package com.freelance.training.vehicle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.freelance.training.vehicle.models.Configuration;

/**
 * provides implementation of CRUD operations for configuration table
 * @author rahul
 */
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1", nativeQuery = true)
	public List<Configuration> findByVarId(Long varid);
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1 and c.type='default'", nativeQuery = true)
	public List<Configuration> findDefaultByVarid(Long varid);
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1 and c.type='interior'", nativeQuery = true)
	public List<Configuration> findInteriorByVarid(Long varid);
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1 and c.type='exterior'", nativeQuery = true)
	public List<Configuration> findExteriorByVarid(Long varid);
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1 and c.type='accessories'", nativeQuery = true)
	public List<Configuration> findAccessoriesByVarid(Long varid);
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1 and c.type='default' and c.configurable='yes'", nativeQuery = true)
	public List<Configuration> findDefaultConfigurableByVarid(Long varid);
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1 and c.type='interior' and c.configurable='yes'", nativeQuery = true)
	public List<Configuration> findInteriorConfigurableByVarid(Long varid);
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1 and c.type='exterior' and c.configurable='yes'", nativeQuery = true)
	public List<Configuration> findExteriorConfigurableByVarid(Long varid);
	
	@Query( value = "SELECT * FROM configuration c where c.var_id=?1 and c.type='accessories' and c.configurable='yes'", nativeQuery = true)
	public List<Configuration> findAccessoriesConfigurableByVarid(Long varid);

}
