package com.paytmamall.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(value = { CartEmptyRequestException.class })
	public ResponseEntity<Object> handleCartEmpty(CartEmptyRequestException e) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		CartEmptyException cartEmptyException = new CartEmptyException(e.getMessage(), e, badRequest,
				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
		return new ResponseEntity<>(cartEmptyException, badRequest);

	}

	@ExceptionHandler(value = { CartEmpty.class })
	public ResponseEntity<Object> handleCartEmpty(CartEmpty e) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		CartEmptyException cartEmptyException = new CartEmptyException(e.getMessage(), e, badRequest,
				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
		return new ResponseEntity<>(cartEmptyException, badRequest);

	}

}
