package com.freelance.training.vehicle.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for the manufacturer table in the database
 * @author rahul
 * 
 */
@Entity
@JsonIgnoreProperties( { "hibernateLazyInitializer", "handler" } )
public class Manufacturer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long man_id;
	private String man_name;
	
	@OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Variant> variants;
	
	public Long getMan_id() {
		return man_id;
	}
	public void setMan_id(Long man_id) {
		this.man_id = man_id;
	}
	public String getMan_name() {
		return man_name;
	}
	public void setMan_name(String man_name) {
		this.man_name = man_name;
	}
	public Set<Variant> getVariants() {
		return variants;
	}
	public void setVariants(Set<Variant> variants) {
		this.variants = variants;
	}
}
