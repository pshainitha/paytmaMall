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
import com.paytmamall.exception.CartEmpty;
import com.paytmmall.entities.PaytmMallBrand;
import com.paytmmall.entities.PaytmMallCart;
import com.paytmmall.entities.PaytmMallProducts;
import com.paytmmall.entities.UserInfo;
import com.paytmmall.service.CartService;
import com.paytmmall.service.PaytmMallProductsService;
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

	@Autowired
	CartService cartService;

	@Autowired
	PaytmMallProductsService productService;

	@Autowired
	PaytmMallCart cart;

	/* Post the brand details */
	@PostMapping("/saveBrand")
	public ResponseEntity<String> postBrand(@RequestBody PaytmMallBrand paytmBrand) {

		ResponseEntity<String> responseEntity;

		responseEntity = new ResponseEntity<String>(paytmService.saveBrand(paytmBrand), HttpStatus.OK);
		return responseEntity;
	}

	/* Search for brand details using brand name */
	@GetMapping("/searchByBrandName/{brandName}")
	public ResponseEntity<?> getBrandByname(@PathVariable("brandName") String brandName) {

		ResponseEntity<?> responseEntity;

		try {
			responseEntity = new ResponseEntity<List<PaytmMallBrand>>(paytmService.findbyname(brandName),
					HttpStatus.OK);

		} catch (BrandDontExistsException e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

	/* Get All the Brand details */
	@GetMapping("/getAllBrands")
	public ResponseEntity<List<PaytmMallBrand>> getAllBrands() {
		ResponseEntity<List<PaytmMallBrand>> responseEntity;
		List<PaytmMallBrand> brandsList = paytmService.getAllBrandsDetails();
		if (brandsList.isEmpty()) {
			responseEntity = new ResponseEntity<List<PaytmMallBrand>>(brandsList, HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<List<PaytmMallBrand>>(brandsList, HttpStatus.OK);
		}
		return responseEntity;
	}

	/* Get the list of product for its respective brand */
	@GetMapping("/getproductsbybrandname/{brandname}")
	public ResponseEntity<List<PaytmMallProducts>> getproducts(@PathVariable("brandname") String brandname) {
		ResponseEntity<List<PaytmMallProducts>> responseEntity;
		try {
			responseEntity = new ResponseEntity<List<PaytmMallProducts>>(
					paytmService.getAllProductsBybrandName(brandname), HttpStatus.OK);

		} catch (BrandDontExistsException e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;

	}

	/* Get the list of product in Dsc order for its respective brand */
	@GetMapping("/getProductsSortedByBrandNameDsc/{brandname}")
	public ResponseEntity<List<PaytmMallProducts>> getproductsSorteddes(@PathVariable("brandname") String brandname) {

		ResponseEntity<List<PaytmMallProducts>> responseEntity;
		try {
			responseEntity = new ResponseEntity<List<PaytmMallProducts>>(
					paytmService.getAllProductsSortedBybrandNameDsc(brandname), HttpStatus.OK);

		} catch (BrandDontExistsException e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;

	}

	/* Get the list of product in Asc order for its respective brand */
	@GetMapping("/getProductsSortedByBrandNameAsc/{brandname}")
	public ResponseEntity<List<PaytmMallProducts>> getproductsSortedAsc(@PathVariable("brandname") String brandname) {

		ResponseEntity<List<PaytmMallProducts>> responseEntity;

		try {
			responseEntity = new ResponseEntity<List<PaytmMallProducts>>(
					paytmService.getAllProductsSortedBybrandNameAsc(brandname), HttpStatus.OK);

		} catch (BrandDontExistsException e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;

	}

	/* Get the count of the products with respect to its brand name */
	@GetMapping("/getcountofproductsByBrandName/{brandname}")
	public ResponseEntity<Integer> getcountofproducts(@PathVariable("brandname") String brandname) {
		ResponseEntity<Integer> responseEntity;

		try {
			responseEntity = new ResponseEntity<Integer>(paytmService.getCountofProductsInBrand(brandname),
					HttpStatus.OK);

		} catch (BrandDontExistsException e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;

	}

	/* Get the list of products of particular brand between the price range */
	@GetMapping("/getproductsByPricerange/{brandname}/{min}/{max}")
	public ResponseEntity<List<PaytmMallProducts>> getproductsByPricerange(@PathVariable("brandname") String brandname,
			@PathVariable("min") Integer min, @PathVariable("max") Integer max) {
		ResponseEntity<List<PaytmMallProducts>> responseEntity;

		try {
			responseEntity = new ResponseEntity<List<PaytmMallProducts>>(
					paytmService.getProductsByPriceRange(brandname, min, max), HttpStatus.OK);

		} catch (BrandDontExistsException e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;

	}

	/* save the user Info */
	@PostMapping("/saveuserinfo")
	public ResponseEntity<String> postUserInfo(@RequestBody UserInfo userInfo) {
		ResponseEntity<String> responseEntity;
		responseEntity = new ResponseEntity<String>(userService.saveUserInfo(userInfo), HttpStatus.OK);
		return responseEntity;
	}

	/* Delete the user */
	@DeleteMapping("/deletetheUser/{id}")
	public ResponseEntity<String> deleteUserInfo(@PathVariable("id") Integer id) {
		ResponseEntity<String> responseEntity;
		responseEntity = new ResponseEntity<String>(userService.deleteUser(id), HttpStatus.OK);
		return responseEntity;
	}

	/* Check if the user exists when Email and password is given */
	@GetMapping("/isUserExist/{email}/{password}")
	public ResponseEntity<String> checkforUser(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		ResponseEntity<String> responseEntity;
		Optional<UserInfo> isuserexist = userService.checkifUserExists(email, password);
		if (isuserexist.isPresent()) {
			responseEntity = new ResponseEntity<String>("Login Success", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("please Register", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	/* Post the cart details */
	@PostMapping("/posttocart/{email}/{pid}/{quantity}")
	public ResponseEntity<String> posttothecart(@PathVariable("email") String email, @PathVariable("pid") Integer pid,
			@PathVariable("quantity") Integer quantity) {
		ResponseEntity<String> responseEntity;
		UserInfo userInfo = userService.findByEmail(email);
		PaytmMallProducts product = productService.getById(pid);
		cart.setPaytmMallproducts(product);
		cart.setUser(userInfo);
		cart.setQuantity(quantity);
		responseEntity = new ResponseEntity<String>(cartService.saveCartInfo(cart), HttpStatus.OK);
		return responseEntity;
	}

	/* Get the cart details */
	@GetMapping("/getCartDetails")
	public ResponseEntity<?> getAllCartDetails() throws CartEmpty, Exception {
		ResponseEntity<List<PaytmMallCart>> responseEntity;
		responseEntity = new ResponseEntity<List<PaytmMallCart>>(cartService.getCartDetails(), HttpStatus.OK);
		return responseEntity;
	}

	/* Delete the cart details */
	@DeleteMapping("/deletetheCart/{id}")
	public ResponseEntity<String> deletetheCart(@PathVariable("id") Integer id) {
		ResponseEntity<String> responseEntity;
		responseEntity = new ResponseEntity<String>(cartService.deletecart(id), HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/deletebyEmailandProductId/{email}/{pid}")
	public ResponseEntity<String> deletebyEmailAndPid(@PathVariable("email") String email,
			@PathVariable("pid") Integer pid) {
		ResponseEntity<String> responseEntity;
//		UserInfo userInfo = userService.findByEmail(email);
//		PaytmMallProducts product = productService.getById(pid);
		responseEntity = new ResponseEntity<String>(cartService.deletecartproduct(email, pid), HttpStatus.OK);
		return responseEntity;
	}
}
