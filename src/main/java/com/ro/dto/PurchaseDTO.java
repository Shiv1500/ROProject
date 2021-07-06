package com.ro.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PurchaseDTO {
	private List<ProductRequest> productRequest ;
	private CustomerRequest customerRequest;
	private PurchaseRequest purchaseRequest;
	private CustomerResponse customerResponse;
	private PurchaseResponse purchaseResponse;
	private List<ProductResponse> productResponse ;

}
