package com.xyztech.api.resourceserver.specification;

import lombok.Data;

@Data
public class ProductSpecParams {

	private int pageSize;
	private String search;
	private String sort;
	private int brandId;
	private int categoryId;
	private String title;
	private final int MaxPageSize=20;
	private int pageIndex=1;
	
	public void setPageSize(int pageSize) {
		if(pageSize > MaxPageSize) {
			this.pageSize= MaxPageSize;
		}
		this.pageSize = pageSize;
	}
	
	public void setSearch(String search) {
		this.search = search.toLowerCase();
	}
}
