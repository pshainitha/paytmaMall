package com.paytmmall.service;

import java.util.List;

import com.paytmamall.exception.BrandDontExistsException;
import com.paytmmall.entities.PaytmMallBrand;
import com.paytmmall.entities.PaytmMallProducts;
import com.paytmmall.entities.UserInfo;

public interface PaytmMallService {

	
	public String saveBrand(PaytmMallBrand paytmMallBrand);

	public List<PaytmMallBrand> findbyname(String brandName) throws BrandDontExistsException;

	public List<PaytmMallBrand> getAllBrandsDetails();

	public List<PaytmMallProducts> getAllProductsBybrandName(String brandname);

	public List<PaytmMallProducts> getAllProductsSortedBybrandNameDsc(String brandname);

	public List<PaytmMallProducts> getAllProductsSortedBybrandNameAsc(String brandname);

	public int getCountofProductsInBrand(String brandname);

	public List<PaytmMallProducts> getProductsByPriceRange(String brandname,int min,int max);

	
	
	
}
