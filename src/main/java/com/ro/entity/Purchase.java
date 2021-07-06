package com.ro.entity;

import java.util.Date;

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
@Table(name = "purchase_details_tbl")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_id")
	private Integer pruchaseId;
	@Column(name = "purchase_date")
	private Date pruchaseDate;
	@Column(name = "purchase_amt")
	private Double pruchaseAmount;

}
