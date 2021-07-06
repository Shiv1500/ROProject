package com.ro.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ProductResponse {
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

}
