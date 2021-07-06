package com.ro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product_details_tbl")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id ;
	@Column(name = "product_id")
	private String product_id ;
	@Column(name = "product_name")
	private String product_name ;
	@Column(name = "product_discription")
	private String product_discription ;
	@Column(name = "warranty_days")
	private Integer warranty_days ;
	@Column(name = "warranty_applicable")
	private Boolean warranty_applicable;
	@Column(name = "manufacture_date")
	private Date  manufacture_date;
	@Column(name = "purchase_price")
	private Double purchase_price;
	@Column(name = "selling_price")
	private Double selling_price;
	@Column(name = "discount")
	private Double discount;
	@Column(name = "quantity")
	private Integer quantity;
	
	
}
