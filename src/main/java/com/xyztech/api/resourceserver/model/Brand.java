package com.xyztech.api.resourceserver.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="brand")
public class Brand {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brandId")
	private Long brandId;
	
	
	@Column(name="brandName")
	private String brandName;
	public Brand() {}
	
	public Brand(String brandName) {
		super();
		this.brandName= brandName;
	}
	
	public Brand(Long brandId) {
		super();
		this.brandId= brandId;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="brand")
	private Set<Product> products;
	
	
	
	
}
