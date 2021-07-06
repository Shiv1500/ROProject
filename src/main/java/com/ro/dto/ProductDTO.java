package com.ro.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductDTO {
	private ProductRequest productRequest;
	private ProductResponse productResponse;

}
