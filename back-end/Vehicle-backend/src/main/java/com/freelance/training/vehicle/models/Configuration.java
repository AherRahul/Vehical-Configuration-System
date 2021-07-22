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
 * POJO for the configuration table in database
 * @author rahul
 * 
 */
@Entity
@JsonIgnoreProperties( { "hibernateLazyInitializer", "handler" } )
public class Configuration {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long conf_id;
	private String description;
	private String type;
	private String configurable;
	private Long var_id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "var_id", nullable = false, insertable=false, updatable=false)
	private Variant variant;
	
	@OneToMany(mappedBy = "configuration", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<AlternateConf> alternateconfs;
	
	public Long getConf_id() {
		return conf_id;
	}
	public void setConf_id(Long conf_id) {
		this.conf_id = conf_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getConfigurable() {
		return configurable;
	}
	public void setConfigurable(String configurable) {
		this.configurable = configurable;
	}
	public Long getVar_id() {
		return var_id;
	}
	public void setVar_id(Long var_id) {
		this.var_id = var_id;
	}
	public Variant getVariant() {
		return variant;
	}
	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	public Set<AlternateConf> getAlternateconfs() {
		return alternateconfs;
	}
	public void setAlternateconfs(Set<AlternateConf> alternateconfs) {
		this.alternateconfs = alternateconfs;
	}
	
	
}
