package com.paytmmall.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table
@Component
/* Brand class with its attributes */
public class PaytmMallBrand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bid;
	String name;
	String imgUrl;

	// one to many relationship with PaytmMallProducts class
	@OneToMany(targetEntity = PaytmMallProducts.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id", referencedColumnName = "bid")
	private List<PaytmMallProducts> paytmMallProducts;

}
