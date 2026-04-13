package com.cognizant.demo.service;

public class ProductAlreadyExistsException extends Exception {
	public ProductAlreadyExistsException(String message) {
		super(message);
	}
}
