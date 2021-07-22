package com.freelance.training.vehicle.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for the variant table in database
 * @author rahul
 * 
 */
@Entity
@JsonIgnoreProperties( { "hibernateLazyInitializer", "handler" } )
public class Variant {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long var_id;
	private String var_name;
	private Long min_qty;
	private double base_price;
	private Long seg_id;
	private Long man_id;
	private String image_path;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seg_id", nullable = false, insertable=false, updatable=false)
	private Segment segment;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "man_id", nullable = false, insertable=false, updatable=false)
	private Manufacturer manufacturer;
	
	
	
	@OneToMany(mappedBy = "variant", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Configuration> configurations;
	
	
	public Long getVar_id() {
		return var_id;
	}
	public void setVar_id(Long var_id) {
		this.var_id = var_id;
	}
	public String getVar_name() {
		return var_name;
	}
	public void setVar_name(String var_name) {
		this.var_name = var_name;
	}
	public Long getMin_qty() {
		return min_qty;
	}
	public void setMin_qty(Long min_qty) {
		this.min_qty = min_qty;
	}
	public double getBase_price() {
		return base_price;
	}
	public void setBase_price(double base_price) {
		this.base_price = base_price;
	}
	public Long getSeg_id() {
		return seg_id;
	}
	public void setSeg_id(Long seg_id) {
		this.seg_id = seg_id;
	}
	public Long getMan_id() {
		return man_id;
	}
	public void setMan_id(Long man_id) {
		this.man_id = man_id;
	}
	public Segment getSegment() {
		return segment;
	}
	public void setSegment(Segment segment) {
		this.segment = segment;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public Set<Configuration> getConfigurations() {
		return configurations;
	}
	public void setConfigurations(Set<Configuration> configurations) {
		this.configurations = configurations;
	}
	
	

}
