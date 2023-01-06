package com.paytmmall.service;

import java.util.List;

import com.paytmamall.exception.BrandDontExistsException;
import com.paytmmall.entities.PaytmMallBrand;
import com.paytmmall.entities.PaytmMallProducts;

public interface PaytmMallService {

	/* Save the brand details */
	public String saveBrand(PaytmMallBrand paytmMallBrand);

	/* Get the List of brands */
	public List<PaytmMallBrand> findbyname(String brandName) throws BrandDontExistsException;

	/* Get the List of Brands */
	public List<PaytmMallBrand> getAllBrandsDetails();

	/* Get the List of products for particular brand name */
	public List<PaytmMallProducts> getAllProductsBybrandName(String brandname) throws BrandDontExistsException;

	/* Get the list of products in dsc order */
	public List<PaytmMallProducts> getAllProductsSortedBybrandNameDsc(String brandname) throws BrandDontExistsException;

	/* Get the list of products in Asc order */
	public List<PaytmMallProducts> getAllProductsSortedBybrandNameAsc(String brandname) throws BrandDontExistsException;

	/* Get the count of products for particular brand name */
	public int getCountofProductsInBrand(String brandname) throws BrandDontExistsException;

	/* Get the list of products by its price range */
	public List<PaytmMallProducts> getProductsByPriceRange(String brandname, int min, int max)
			throws BrandDontExistsException;

	// public PaytmMallProducts findByProductId(Integer pid);

}
