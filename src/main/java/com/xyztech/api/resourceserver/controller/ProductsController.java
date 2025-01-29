package com.xyztech.api.resourceserver.controller;

import java.util.Arrays;
import java.util.List;

import com.xyztech.api.resourceserver.dto.ProductResponseDto;
import com.xyztech.api.resourceserver.dto.ProductResponseListDto;
import com.xyztech.api.resourceserver.model.Brand;
import com.xyztech.api.resourceserver.model.Category;
import com.xyztech.api.resourceserver.repository.BrandRepository;
import com.xyztech.api.resourceserver.repository.CategoryRepository;
import com.xyztech.api.resourceserver.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xyztech.api.resourceserver.specification.ProductSpecParams;


@RestController
@RequestMapping("/api/shop")
@Slf4j
public class ProductsController {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/categories")
	 public ResponseEntity<List<Category>> getCategories() {
		 List<Category> categories = categoryRepository.findAll();
		 if(categories != null) {
			 return ResponseEntity.ok(categories);
		 }
		 
		 return ResponseEntity.noContent().build();
	 } 
	
	@GetMapping("/brands")
	 public ResponseEntity<List<Brand>> getBrands() {
		 List<Brand> brands = brandRepository.findAll();
		 if(brands != null) {
			 return ResponseEntity.ok(brands);
		 }
		 
		 return ResponseEntity.noContent().build();
	 } 
	
	@GetMapping("/products")
	public ResponseEntity<ProductResponseListDto> getProducts(ProductSpecParams requestParams) {
		log.info("request param {}",requestParams);
		ProductResponseListDto productList = productService.getProductList(requestParams);
		return ResponseEntity.ok(productList);
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id) {
		
		ProductResponseDto product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}
}
