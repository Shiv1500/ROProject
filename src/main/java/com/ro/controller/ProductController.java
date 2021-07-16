package com.ro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ro.dto.ProductRequest;
import com.ro.dto.ProductResponse;
import com.ro.service.ProductService;

@RestController
public class ProductController {
	@Autowired	
	private ProductService  productService ;

	@GetMapping(value = "/getAllProduct")
	public List<ProductResponse> getAllProduct() {
		return productService.findAllProduct();
	}

	@PostMapping(value = "/saveProduct")
	public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest) throws Exception {
		try {
			ProductResponse productResponse = productService.saveProduct(productRequest);
			return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.OK);			
		}catch(Exception exp){
			throw exp;
		} 
	}

	@GetMapping(value = "/getProductById/{productId}")
	public List<ProductResponse> getProductById(@PathVariable("productId") String productId) {
		return productService.findProductById(productId);
	}

	@GetMapping(value = "/getProductByName/{productName}")
	public List<ProductResponse> getProductByName(@PathVariable("productName") String productName) {
		return productService.findProductByName(productName);
	}

	@PutMapping(value = "/updateProduct")
	public Integer updateProduct(@RequestBody ProductRequest productRequest) {
		return productService.updateProduct(productRequest);
	}
}
