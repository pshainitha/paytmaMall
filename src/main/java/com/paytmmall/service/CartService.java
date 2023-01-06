package com.paytmmall.service;

import java.util.List;

import com.paytmamall.exception.CartEmptyRequestException;
import com.paytmmall.entities.PaytmMallCart;

public interface CartService {

	String saveCartInfo(PaytmMallCart cart);

	List<PaytmMallCart> getCartDetails() throws CartEmptyRequestException;

//	String deletecart(String email, Integer id);

	String deletecart(Integer id);

	String deletecartproduct(String email, Integer pid);

}
