package com.cognizant.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.Product;
import com.cognizant.demo.service.ProductAlreadyExistsException;
import com.cognizant.demo.service.ProductNotFoundException;
import com.cognizant.demo.service.ProductService;

@RestController
@RequestMapping("/product")
//cross origin when we call this from reactjs
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) throws ProductAlreadyExistsException {
		return ps.create(product);
	}
	
	@GetMapping
	public List<Product> retrieveAllProducts() {
		return ps.read();
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable("id") Integer productId) throws ProductNotFoundException {
		return ps.read(productId);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Integer id,@RequestBody Product product) throws ProductNotFoundException {
		return ps.update(product);
	}
	
	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable Integer id) throws ProductNotFoundException {
		return ps.delete(id);
	}
	
	
}
