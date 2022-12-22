package com.paytmmall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.paytmmall.entities.PaytmMallBrand;
import com.paytmmall.entities.PaytmMallProducts;
@Repository
public interface PaytmmallDao extends JpaRepository<PaytmMallBrand, Integer>{

	
	
	@Query("From PaytmMallBrand p where p.name=:brandName")
	public List<PaytmMallBrand> findByName(String brandName);

	
	@Query(value="SELECT pb.paytmMallProducts From PaytmMallBrand pb where pb.name=:brandname")
	public List<PaytmMallProducts> getproductbyBrandname(@Param("brandname") String brandname);


//	public List<PaytmMallProducts> findByPriceBetween(int min, int max);


	

	
}
