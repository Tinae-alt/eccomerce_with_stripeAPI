package com.xyztech.api.resourceserver.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class ProductResponseListDto {

	private int totalPages;
	private long totalCount;
	private int pageIndex;
	private int pageSize;
	private List<ProductResponseDto> productList;
	
	public ProductResponseListDto() {
		productList = new ArrayList<>();
	}
	
	
	
}
