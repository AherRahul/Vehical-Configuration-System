package com.freelance.training.vehicle.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO for the alternate_conf table in database
 * @author rahul
 * 
 */
@Entity
@JsonIgnoreProperties( { "hibernateLazyInitializer", "handler" } )
public class AlternateConf {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alt_id;
	private String alt_description;
	private double alt_price;
	private Long conf_id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conf_id", nullable = false, insertable=false, updatable=false)
	private Configuration configuration;
	
	public Long getAlt_id() {
		return alt_id;
	}
	public void setAlt_id(Long alt_id) {
		this.alt_id = alt_id;
	}
	public String getAlt_description() {
		return alt_description;
	}
	public void setAlt_description(String alt_description) {
		this.alt_description = alt_description;
	}
	public double getAlt_price() {
		return alt_price;
	}
	public void setAlt_price(double alt_price) {
		this.alt_price = alt_price;
	}
	public Long getVar_id() {
		return conf_id;
	}
	public void setVar_id(Long var_id) {
		this.conf_id = var_id;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

}
