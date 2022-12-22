package com.paytmmall.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytmamall.exception.BrandDontExistsException;
import com.paytmmall.dao.PaytmmallDao;
import com.paytmmall.entities.PaytmMallBrand;
import com.paytmmall.entities.PaytmMallProducts;
import com.paytmmall.entities.UserInfo;

@Service
public class PaytmMallServiceImpl implements PaytmMallService{

	@Autowired
	PaytmmallDao paytmDao;

	@Override
	public String saveBrand(PaytmMallBrand paytmMallBrand) {
		// TODO Auto-generated method stub
		paytmDao.save(paytmMallBrand);
		return "Brand saved success";
	}

	@Override
	public List<PaytmMallBrand> findbyname(String brandName) throws BrandDontExistsException {
		// TODO Auto-generated method stub
		System.out.println(brandName);
		List<PaytmMallBrand> brands=paytmDao.findByName(brandName);
		if(brands.isEmpty()) {
			throw new BrandDontExistsException("Sorry "+brandName+" doesnt exists");
		}
		else {
			return brands;
		}
		
	}

	@Override
	public List<PaytmMallBrand> getAllBrandsDetails() {
		// TODO Auto-generated method stub
		List<PaytmMallBrand> brandsList=paytmDao.findAll();
		return brandsList;
	}

	@Override
	public List<PaytmMallProducts> getAllProductsBybrandName(String brandname) {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> brand=paytmDao.getproductbyBrandname(brandname);
		return brand;
	}

	@Override
	public List<PaytmMallProducts> getAllProductsSortedBybrandNameDsc(String brandname) {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> products=paytmDao.getproductbyBrandname(brandname);
//		//sorting on descending order
		Comparator<PaytmMallProducts>  priceCommparator = Comparator.comparing(PaytmMallProducts::getPrice);
       List<PaytmMallProducts>  listSorted = (List<PaytmMallProducts>) products.stream().sorted(priceCommparator.reversed()).collect(Collectors.toList());
       System.out.println(products);
       System.out.println(listSorted);
        return  listSorted;

	}

	@Override
	public List<PaytmMallProducts> getAllProductsSortedBybrandNameAsc(String brandname) {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> products=paytmDao.getproductbyBrandname(brandname);
//		//sorting on descending order
		Comparator<PaytmMallProducts>  priceCommparator = Comparator.comparing(PaytmMallProducts::getPrice);
       List<PaytmMallProducts>  listSorted = (List<PaytmMallProducts>) products.stream().sorted(priceCommparator).collect(Collectors.toList());
       System.out.println(products);
       System.out.println(listSorted);
        return  listSorted;

	}

	@Override
	public int getCountofProductsInBrand(String brandname) {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> products=paytmDao.getproductbyBrandname(brandname);
		int listSize=products.size();
		return listSize;
	}

	@Override
	public List<PaytmMallProducts> getProductsByPriceRange(String brandname,int min,int max) {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> productslist1=paytmDao.getproductbyBrandname(brandname);
		System.out.println("shain");
		System.out.println(productslist1.get(1));
		System.out.println(productslist1.get(2));
		List<PaytmMallProducts> productslist2=new ArrayList<PaytmMallProducts>();
		for(int i=0;i<productslist1.size();i++) {
			int price=productslist1.get(i).price;
			if(price>=min && price<=max) {
				
				productslist2.add(productslist1.get(i));
			}
		}
		Comparator<PaytmMallProducts>  priceCommparator = Comparator.comparing(PaytmMallProducts::getPrice);
	    List<PaytmMallProducts>  listSorted = (List<PaytmMallProducts>) productslist2.stream().sorted(priceCommparator).collect(Collectors.toList());
		
		return listSorted;
}

	

	



}
