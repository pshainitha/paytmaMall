package com.paytmmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytmmall.dao.PaytmallProductsDao;
import com.paytmmall.entities.PaytmMallProducts;

@Service
public class PaytmMallProductsServiceImpl implements PaytmMallProductsService {

	@Autowired
	PaytmallProductsDao productsDao;

	@Override
	public PaytmMallProducts getById(int pid) {
		// TODO Auto-generated method stub
		PaytmMallProducts product = productsDao.getReferenceById(pid);

		return product;
	}

}
