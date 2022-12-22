package com.paytmmall.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table
@Component
@Data
public class PaytmMallProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	public int price;
	
	} 
