package com.ro.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
	private Integer addressId;
	private String latitude;
	private String lognitude;
	private String flatNo;
	private String landmark;
	private String state;
	private String pincode;
	private Integer custId;
}
