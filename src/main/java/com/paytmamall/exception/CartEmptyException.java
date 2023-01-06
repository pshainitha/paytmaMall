package com.paytmamall.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class CartEmptyException {

	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	private final ZonedDateTime dateTime;

	public CartEmptyException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime dateTime) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
		this.dateTime = dateTime;
	}

}
