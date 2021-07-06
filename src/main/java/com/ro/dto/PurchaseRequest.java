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
public class PurchaseRequest {
	private Integer pruchaseId;
	private Date pruchaseDate;
	private Double pruchaseAmount;

}
