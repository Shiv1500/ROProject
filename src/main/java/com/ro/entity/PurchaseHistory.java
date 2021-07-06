package com.ro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data	
@Entity
@Table(name = "purchase_history_tbl")
public class PurchaseHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="purchase_history_id")
	private Integer purchaseHistoryId;
	@Column(name="product_id")
	private String productId;
	@Column(name="purchase_qty")
	private Integer purchaseQty;
	@Column(name="cust_id")
	private Integer custId;
	@Column(name="purchase_id")
	private Integer purchaseId;
}
