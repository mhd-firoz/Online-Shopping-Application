package com.amfa.online.shop.product.service;

import java.util.List;

import com.amfa.online.shop.product.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();
		
	public Product saveProduct(Product product);
}
