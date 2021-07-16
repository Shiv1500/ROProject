package com.ro.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
	private String productId ;
	private String productName ;
	private String productDiscription ;
	private Integer warrantyDays ;
	private Boolean warrantyApplicable;
	private Date manufactureDate;
	private Double purchasePrice;
	private Double sellingPrice;
	private Double discount;
	private Integer quantity;
	private Date warrantyExpiryDate;
}
