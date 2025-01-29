package com.xyztech.api.resourceserver.service;


import com.xyztech.api.resourceserver.dto.ProductResponseDto;
import com.xyztech.api.resourceserver.dto.ProductResponseListDto;
import com.xyztech.api.resourceserver.specification.ProductSpecParams;

public interface IProductService {

	
	public ProductResponseDto getProductById(long id);
	public ProductResponseListDto getProductList(ProductSpecParams specParams);
	
}
