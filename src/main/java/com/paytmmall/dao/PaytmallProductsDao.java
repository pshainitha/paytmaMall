package com.paytmmall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paytmmall.entities.PaytmMallProducts;

@Repository
public interface PaytmallProductsDao extends JpaRepository<PaytmMallProducts, Integer> {

}