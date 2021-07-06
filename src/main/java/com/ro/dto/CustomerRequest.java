package com.ro.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
	private Integer id;
	private String customerId;
	private String customerName; 
	private String mobileNumber;
	private String alternateMobileNumber; 
	private String email;
	private String model;
	private String serviceType; 
	private String charge; 
	private AddressRequest addressRequest;
}
