package com.paytmmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytmamall.exception.CartEmptyRequestException;
import com.paytmmall.dao.CartDao;
import com.paytmmall.entities.PaytmMallCart;
import com.paytmmall.entities.UserInfo;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartdao;

	@Autowired
	PaytmMallCart cart;

	@Autowired
	UserInfo userdao;

	@Override
	public String saveCartInfo(PaytmMallCart cart) {
		// TODO Auto-generated method stub

		cartdao.save(cart);
		return "cart saved";
	}

	@Override
	public List<PaytmMallCart> getCartDetails() throws CartEmptyRequestException {
		// TODO Auto-generated method stub
		List<PaytmMallCart> cartsdetails;
		if (!cartdao.findAll().isEmpty()) {
			cartsdetails = cartdao.findAll();
			return cartsdetails;
		}
//		return null;
		else {
			throw new CartEmptyRequestException("Cart is Empty");
		}

	}

	@Override
	public String deletecart(Integer id) {
		// TODO Auto-generated method stub
		cartdao.deleteById(id);
		return "cart with id= " + id + " deleted successfully";
	}

	@Override
	public String deletecartproduct(String email, Integer pid) {
		// TODO Auto-generated method stub
		cartdao.deleteproductincart(email, pid);
		return "deleted success";
	}

//	@Override
//	public String deletecart(String email, Integer id) {
//		// TODO Auto-generated method stub
//		cartdao.deleteproductincart(email, id);
//		return "product deleted success";
//	}

}
