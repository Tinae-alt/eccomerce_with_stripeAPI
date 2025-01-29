package com.xyztech.api.resourceserver.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	private Long productId;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unitPrice")
	private double unitPrice;
	
	
	@Column(name="imageUrl")
	private String imageUrl;
	 
	@Column(name="active")
	private boolean active;
	
	@Column(name="unitsınStock")
	private int unitsInStock;
	
	@Column(name="dateCreated")
	@CreationTimestamp
	private Date dateCreated;
	
	@Column(name="lastUpdated")
	@UpdateTimestamp
	private Date lastUpdated;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="categoryId", nullable=false)
	private Category category;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="brandId", nullable=false)
	private Brand brand;
	
	public Product() {}

	public Product(Category category, Brand brand,String sku, String title, String description, double unitPrice, String imageUrl,
			boolean active, int unitsInStock, Date dateCreated, Date lastUpdated) {
		super();
		this.sku = sku;
		this.title = title;
		this.description = description;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.active = active;
		this.unitsInStock = unitsInStock;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.category = category;
		this.brand = brand;
	}
	
	
	
}
