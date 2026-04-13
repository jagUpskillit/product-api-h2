package com.cognizant.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.entity.Product;
import com.cognizant.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pr;
	
	public Product create(Product product) throws ProductAlreadyExistsException {
		if(product.getId()==null)
			return pr.save(product);
		else
			throw new ProductAlreadyExistsException("Product with id: "+product.getId()+" already exists. If you want to update, then try PUT");
	}
	public List<Product> read() {
		return pr.findAll();
	}
	public Product read(Integer id) throws ProductNotFoundException {
		Optional<Product> temp = pr.findById(id);
		Product product=null;
		if(temp.isPresent()) {
			product=temp.get();
		}else {
			throw new ProductNotFoundException("There is no product with id: "+id);
		}
		return product;
	}
	public Product update(Product product) throws ProductNotFoundException {
		if(product.getId()==null) {
			throw new ProductNotFoundException("There is no product with id: "+product.getId());
		}else {
			pr.save(product);
		}
		return product;
	}
	public Product delete(Integer id) throws ProductNotFoundException {
		Product product = read(id);
		if(product!=null) {
			pr.delete(product);
		}
		return product;
	}
	
}
