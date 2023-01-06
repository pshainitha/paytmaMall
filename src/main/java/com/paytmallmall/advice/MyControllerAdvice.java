//package com.paytmallmall.advice;
//
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.paytmamall.exception.CartEmptyException;
//import com.paytmamall.exception.CartEmptyRequestException;
//
//@ControllerAdvice
//public class MyControllerAdvice {
//
//	@ExceptionHandler(value = { CartEmptyRequestException.class })
//	public ResponseEntity<Object> handleCartEmpty(CartEmptyRequestException e) {
//		CartEmptyException cartEmptyException = new CartEmptyException(e.getMessage(), e, HttpStatus.BAD_REQUEST,
//				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
//		return new ResponseEntity<Object>(cartEmptyException, HttpStatus.BAD_REQUEST);
//
//	}
//
//}
