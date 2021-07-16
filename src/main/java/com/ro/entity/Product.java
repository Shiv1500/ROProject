package com.ro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product_details_tbl",uniqueConstraints={
	    @UniqueConstraint(columnNames = {"product_id", "product_name"})}) 
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id ;
	@Column(name = "product_id")
	private String productId ;
	@Column(name = "product_name")
	private String productName ;
	@Column(name = "product_discription")
	private String productDiscription ;
	@Column(name = "warranty_days")
	private Integer warrantyDays ;
	@Column(name = "warranty_applicable",columnDefinition = "boolean default false")
	private Boolean warrantyApplicable;
	@Column(name = "manufacture_date")
	private Date  manufactureDate;
	@Column(name = "purchase_price")
	private Double purchasePrice;
	@Column(name = "selling_price")
	private Double sellingPrice;  
	@Column(name = "discount")
	private Double discount;
	@Column(name = "quantity")
	private Integer quantity;


}
