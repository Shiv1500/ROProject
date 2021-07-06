package com.ro.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configurable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_details_tbl")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	@Column(name = "customer_id",unique = true)
	private String customerId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "alternate_mobile_number")
	private String alternateMobileNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "model")
	private String model;
	@Column(name = "service_type")
	private String serviceType; 
	@Column(name = "charge")
	private String charge; 
	@Column(name = "address_id")
	@OneToMany(fetch=FetchType.LAZY,targetEntity = Address.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="cust_id",referencedColumnName = "id")
	private List<Address>  address;
}
