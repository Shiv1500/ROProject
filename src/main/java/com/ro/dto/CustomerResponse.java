package com.ro.dto;

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
public class CustomerResponse {
	private Integer id;
	private String customerId;
	private String customerName; 
	private String mobileNumber;
	private String alternateMobileNumber; 
	private String email;
	private String model;
	private String serviceType; 
	private String charge; 
	private AddressResponse addressResponse; 
}
