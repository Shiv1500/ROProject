package com.ro.entity;

import java.io.Serializable;

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
@Table(name = "address_details")
public class Address  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "lognitude")
	private String lognitude;
	@Column(name = "flatNo")
	private String flatNo;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "cust_id")
	private Integer custId;
}
