package com.cognizant.demo.service;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String message) {
		super(message);
	}
}
