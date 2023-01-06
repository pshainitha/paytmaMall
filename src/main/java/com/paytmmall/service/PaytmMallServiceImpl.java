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

@Service
public class PaytmMallServiceImpl implements PaytmMallService {

	@Autowired
	PaytmmallDao paytmDao;

	/* Save the brand details */
	@Override
	public String saveBrand(PaytmMallBrand paytmMallBrand) {
		// TODO Auto-generated method stub
		paytmDao.save(paytmMallBrand);
		return "Brand saved success";
	}

	/* Get the List of brands */
	@Override
	public List<PaytmMallBrand> findbyname(String brandName) throws BrandDontExistsException {
		// TODO Auto-generated method stub
		System.out.println(brandName);
		List<PaytmMallBrand> brands = paytmDao.findByName(brandName);
		if (brands.isEmpty()) {
			throw new BrandDontExistsException("Sorry " + brandName + " doesnt exists");
		} else {
			return brands;
		}

	}

	/* Get the List of Brands */
	@Override
	public List<PaytmMallBrand> getAllBrandsDetails() {
		// TODO Auto-generated method stub
		List<PaytmMallBrand> brandsList = paytmDao.findAll();
		return brandsList;
	}

	/* Get the List of products for particular brand name */
	@Override
	public List<PaytmMallProducts> getAllProductsBybrandName(String brandname) throws BrandDontExistsException {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> brand = paytmDao.getproductbyBrandname(brandname);

		if (brand.isEmpty()) {
			throw new BrandDontExistsException("Sorry " + brandname + " doesnt exists");
		} else {
			return brand;
		}
	}

	/* Get the list of products in dsc order */
	@Override
	public List<PaytmMallProducts> getAllProductsSortedBybrandNameDsc(String brandname)
			throws BrandDontExistsException {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> products = paytmDao.getproductbyBrandname(brandname);
		// sorting on descending order using comparator
		Comparator<PaytmMallProducts> priceCommparator = Comparator.comparing(PaytmMallProducts::getPrice);
		List<PaytmMallProducts> listSorted = (List<PaytmMallProducts>) products.stream()
				.sorted(priceCommparator.reversed()).collect(Collectors.toList());
		System.out.println(products);
		System.out.println(listSorted);

		if (listSorted.isEmpty()) {
			throw new BrandDontExistsException("Sorry " + brandname + " doesnt exists");
		} else {
			return listSorted;
		}

	}

	/* Get the list of products in Asc order */
	@Override
	public List<PaytmMallProducts> getAllProductsSortedBybrandNameAsc(String brandname)
			throws BrandDontExistsException {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> products = paytmDao.getproductbyBrandname(brandname);
		// sorting on Asc order using comparator
		Comparator<PaytmMallProducts> priceCommparator = Comparator.comparing(PaytmMallProducts::getPrice);
		List<PaytmMallProducts> listSorted = (List<PaytmMallProducts>) products.stream().sorted(priceCommparator)
				.collect(Collectors.toList());
		System.out.println(products);
		System.out.println(listSorted);

		if (listSorted.isEmpty()) {
			throw new BrandDontExistsException("Sorry " + brandname + " doesnt exists");
		} else {
			return listSorted;
		}

	}

	/* Get the count of products for particular brand name */
	@Override
	public int getCountofProductsInBrand(String brandname) throws BrandDontExistsException {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> products = paytmDao.getproductbyBrandname(brandname);
		if (products.isEmpty()) {
			throw new BrandDontExistsException("Sorry " + brandname + " doesnt exists");
		} else {
			int listSize = products.size();
			return listSize;

		}
	}

	/* Get the list of products by its price range */
	@Override
	public List<PaytmMallProducts> getProductsByPriceRange(String brandname, int min, int max)
			throws BrandDontExistsException {
		// TODO Auto-generated method stub
		List<PaytmMallProducts> productslist1 = paytmDao.getproductbyBrandname(brandname);
		List<PaytmMallProducts> products = paytmDao.getproductbyBrandname(brandname);
		if (products.isEmpty()) {
			throw new BrandDontExistsException("Sorry " + brandname + " doesnt exists");
		} else {
			// get the list of products between the price range
			System.out.println(productslist1.get(1));
			System.out.println(productslist1.get(2));
			List<PaytmMallProducts> productslist2 = new ArrayList<PaytmMallProducts>();
			for (int i = 0; i < productslist1.size(); i++) {
				int price = productslist1.get(i).price;
				if (price >= min && price <= max) {

					productslist2.add(productslist1.get(i));
				}
			}
			// using comparator to sort the list
			Comparator<PaytmMallProducts> priceCommparator = Comparator.comparing(PaytmMallProducts::getPrice);
			List<PaytmMallProducts> listSorted = (List<PaytmMallProducts>) productslist2.stream()
					.sorted(priceCommparator).collect(Collectors.toList());

			return listSorted;

		}

	}

}
