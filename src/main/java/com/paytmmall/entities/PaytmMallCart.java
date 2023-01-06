package com.paytmmall.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table
@Component
/* Cart class with its attributes */
public class PaytmMallCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cartid;
	int quantity;

	// many to one relationship with UserInfo class
	@ManyToOne(targetEntity = UserInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "useremail", referencedColumnName = "email")
	// private String useremail;
	private UserInfo user;

	// many to one relationship with PaytmMallProducts class
	@ManyToOne(targetEntity = PaytmMallProducts.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "pid", referencedColumnName = "pid")
	// private int productid;
	private PaytmMallProducts paytmMallproducts;

}
