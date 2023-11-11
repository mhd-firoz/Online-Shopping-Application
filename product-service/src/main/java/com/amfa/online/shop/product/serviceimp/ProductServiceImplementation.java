package com.amfa.online.shop.product.serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amfa.online.shop.product.model.Product;
import com.amfa.online.shop.product.repository.ProductRepository;
import com.amfa.online.shop.product.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService{

	// Inject as constuctor
	private ProductRepository productRepository;
	
	public ProductServiceImplementation(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
	
		return productRepository.insert(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Product product) {
		// TODO Auto-generated method stub
		return null;
	}


	

	

	
	 

	
	

	

}
