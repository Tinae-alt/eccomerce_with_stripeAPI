package com.xyztech.api.resourceserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xyztech.api.resourceserver.dto.ProductResponseDto;
import com.xyztech.api.resourceserver.dto.ProductResponseListDto;
import com.xyztech.api.resourceserver.model.Product;
import com.xyztech.api.resourceserver.repository.ProductRepository;
import com.xyztech.api.resourceserver.specification.ProductSpecParams;
import com.xyztech.api.resourceserver.specification.ProductSpecificationTitleBrandCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

	
	@Value("${pagination.page.size.default}")
	private Integer defaultPageSize;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductSpecificationTitleBrandCategory productSpecification;
	@Override
	public ProductResponseDto getProductById(long id) {
		Optional<Product> productOpt = productRepository.findById(id);
		if(productOpt.isPresent()) {
			ProductResponseDto prdto = new ProductResponseDto();
			prdto.populateDto(productOpt.get());
			return prdto;
		}
		return null;
	}

	@Override
	public ProductResponseListDto getProductList(ProductSpecParams specParams) {
		
		List<Product> productList = null;
		Page<Product> pages = null;
		if (Integer.valueOf(specParams.getPageIndex()) == null) {
			
			pages = new PageImpl<>(productRepository.findAll(productSpecification.getProducts(specParams)));
		}
		else {
			if(Integer.valueOf(specParams.getPageSize()) == null || specParams.getPageSize() == 0) {
				specParams.setPageSize(defaultPageSize);
			}
			Pageable paging = PageRequest.of(specParams.getPageIndex() -1, specParams.getPageSize());
			
			pages = productRepository.findAll(productSpecification.getProducts(specParams), paging);
		}
		if(pages != null && pages.getContent() != null ) {
			
			productList = pages.getContent();
			if(productList != null && productList.size() > 0) {
				
				ProductResponseListDto prldto = new ProductResponseListDto();
				prldto.setTotalPages(pages.getTotalPages());
				prldto.setTotalCount(pages.getTotalElements());
				prldto.setPageIndex(pages.getNumber()+1);
				prldto.setPageSize(specParams.getPageSize());
				prldto.setProductList(new ArrayList<ProductResponseDto>());
				for(Product product: productList) {
					
					ProductResponseDto prdto= new ProductResponseDto();
					prdto.populateDto(product);
					prldto.getProductList().add(prdto);
				}
				return prldto;
			}
		}
		return null;
	}

}
