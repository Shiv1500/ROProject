package com.ro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ro.dto.ProductRequest;
import com.ro.dto.ProductResponse;

@Service
public interface ProductService {
	public Integer saveProduct(ProductRequest productRequest);
	public List<ProductResponse>findAllProduct();
	public List<ProductResponse>findProductById(String producId);
	public List<ProductResponse>findProductByName(String producName);
	public Integer updateProduct(ProductRequest productRequest);
	public Integer deleteProduct(String producId);
}
