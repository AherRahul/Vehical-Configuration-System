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
 * POJO for the segment table in database
 * @author rahul
 * 
 */
@Entity
@JsonIgnoreProperties( { "hibernateLazyInitializer", "handler" } )
public class Segment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seg_id;
	private String seg_name;
	
	@OneToMany(mappedBy = "segment", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Variant> variants;
	
	public Long getSeg_id() {
		return seg_id;
	}
	public void setSeg_id(Long seg_id) {
		this.seg_id = seg_id;
	}
	public String getSeg_name() {
		return seg_name;
	}
	public void setSeg_name(String seg_name) {
		this.seg_name = seg_name;
	}
	public Set<Variant> getVariants() {
		return variants;
	}
	public void setVariants(Set<Variant> variants) {
		this.variants = variants;
	}
	
	

}
