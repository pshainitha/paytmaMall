package com.paytmmall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paytmamall.exception.BrandDontExistsException;
import com.paytmmall.dao.PaytmmallDao;
import com.paytmmall.entities.PaytmMallBrand;
import com.paytmmall.entities.PaytmMallProducts;
import com.paytmmall.entities.UserInfo;
import com.paytmmall.service.PaytmMallService;
import com.paytmmall.service.UserInfoService;



@RestController
@RequestMapping("paytMall")
@CrossOrigin("*")
public class PaytmMallController {

	@Autowired
	PaytmMallService paytmService;
	
	@Autowired
	UserInfoService userService;
	
	@PostMapping("/saveBrand")
	public ResponseEntity<String> postBrand(@RequestBody PaytmMallBrand paytmBrand){
		
		ResponseEntity<String> responseEntity;
		
		
		 responseEntity = new ResponseEntity<String>(paytmService.saveBrand(paytmBrand),HttpStatus.OK);
		 return responseEntity;
	}
	
	
	@GetMapping("/searchByBrandName/{brandName}")
	public ResponseEntity<?> getBrandByname(@PathVariable("brandName") String brandName){		
		
		ResponseEntity<?> responseEntity;
		
//		List<PaytmMallBrand> brandDetails=paytmService.findbyname(brandName);
//		if(!brandDetails.isEmpty()) {
//		
//		responseEntity=new ResponseEntity<List<PaytmMallBrand>>(brandDetails,HttpStatus.OK);
//		
//	}		else {
//				String message="Brand doesnt exists";
//			responseEntity=new ResponseEntity<String>("Brand doesnt exists",HttpStatus.BAD_REQUEST);
//		}
		try{
			responseEntity = new ResponseEntity<List<PaytmMallBrand>>(paytmService.findbyname(brandName), HttpStatus.OK);

		}
		catch (BrandDontExistsException e) {
			responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);

		}
		catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}
	
	
	@GetMapping("/getAllBrands")
	public ResponseEntity<List<PaytmMallBrand>> getAllBrands(){
		ResponseEntity<List<PaytmMallBrand>> responseEntity;
		List<PaytmMallBrand> brandsList=paytmService.getAllBrandsDetails();
		if(brandsList.isEmpty()) {
			responseEntity=new ResponseEntity<List<PaytmMallBrand>>(brandsList,HttpStatus.NO_CONTENT);
		}
		else {
			responseEntity=new ResponseEntity<List<PaytmMallBrand>>(brandsList,HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("/getproductsbybrandname/{brandname}")
	public ResponseEntity<List<PaytmMallProducts>> getproducts(@PathVariable("brandname") String brandname){
		ResponseEntity<List<PaytmMallProducts>> responseEntity;
		List<PaytmMallProducts> productsList=paytmService.getAllProductsBybrandName(brandname);
		if(productsList.isEmpty()) {
			responseEntity=new ResponseEntity<List<PaytmMallProducts>>(productsList,HttpStatus.NO_CONTENT);
		}
		else {
			responseEntity=new ResponseEntity<List<PaytmMallProducts>>(productsList,HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("/getProductsSortedByBrandNameDsc/{brandname}")
	public ResponseEntity<List<PaytmMallProducts>> getproductsSorteddes(@PathVariable("brandname") String brandname){
		System.out.println("shain");
		ResponseEntity<List<PaytmMallProducts>> responseEntity;
		List<PaytmMallProducts> productsList=paytmService.getAllProductsSortedBybrandNameDsc(brandname);
		if(productsList.isEmpty()) {
			responseEntity=new ResponseEntity<List<PaytmMallProducts>>(productsList,HttpStatus.NO_CONTENT);
		}
		else {
			responseEntity=new ResponseEntity<List<PaytmMallProducts>>(productsList,HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/getProductsSortedByBrandNameAsc/{brandname}")
	public ResponseEntity<List<PaytmMallProducts>> getproductsSortedAsc(@PathVariable("brandname") String brandname){
		System.out.println("shain");
		ResponseEntity<List<PaytmMallProducts>> responseEntity;
		List<PaytmMallProducts> productsList=paytmService.getAllProductsSortedBybrandNameAsc(brandname);
		if(productsList.isEmpty()) {
			responseEntity=new ResponseEntity<List<PaytmMallProducts>>(productsList,HttpStatus.NO_CONTENT);
		}
		else {
			responseEntity=new ResponseEntity<List<PaytmMallProducts>>(productsList,HttpStatus.OK);
		}
		return responseEntity;
		
	}
	@GetMapping("/getcountofproductsByBrandName/{brandname}")
	public ResponseEntity<Integer> getcountofproducts(@PathVariable("brandname") String brandname){
		ResponseEntity<Integer> responseEntity;
		int count = paytmService.getCountofProductsInBrand(brandname);
		if(count==0) {
			responseEntity=new ResponseEntity<Integer>(count,HttpStatus.NO_CONTENT);
		}
		else {
			responseEntity=new ResponseEntity<Integer>(count,HttpStatus.OK);
		}
		return responseEntity;
	}
	
	
	@GetMapping("/getproductsByPricerange/{brandname}/{min}/{max}")
	public ResponseEntity<List<PaytmMallProducts>> getproductsByPricerange(@PathVariable("brandname") String brandname,@PathVariable("min") Integer min,@PathVariable("max") Integer max){
		ResponseEntity<List<PaytmMallProducts>> responseEntity;
		List<PaytmMallProducts> productslist=paytmService.getProductsByPriceRange(brandname,min,max);
		if(productslist.isEmpty()) {
			responseEntity=new ResponseEntity<List<PaytmMallProducts>>(productslist,HttpStatus.NO_CONTENT);
		}
		else {
			responseEntity=new ResponseEntity<List<PaytmMallProducts>>(productslist,HttpStatus.OK);
		}
		return responseEntity;
		
	}
	
	@PostMapping("/saveuserinfo")
	public ResponseEntity<String> postUserInfo(@RequestBody UserInfo userInfo){
		ResponseEntity<String> responseEntity;
		 responseEntity = new ResponseEntity<String>(userService.saveUserInfo(userInfo),HttpStatus.OK);
		 return responseEntity;
	}
	
	@DeleteMapping("/deletetheUser/{id}")
	public ResponseEntity<String> deleteUserInfo(@PathVariable("id") Integer id){
		ResponseEntity<String> responseEntity;
		responseEntity = new ResponseEntity<String>(userService.deleteUser(id),HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/isUserExist/{email}/{password}")
	public ResponseEntity<String> checkforUser(@PathVariable("email") String email,@PathVariable("password") String password){
		ResponseEntity<String> responseEntity;
		Optional<UserInfo> isuserexist=userService.checkifUserExists(email, password);
		if(isuserexist.isPresent()) {
			responseEntity = new ResponseEntity<String>("Login Success",HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<String>("please Register",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
}
