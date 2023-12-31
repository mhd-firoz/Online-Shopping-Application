package com.amfa.online.shop.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amfa.online.shop.product.model.Product;
import com.amfa.online.shop.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	private ProductService productService;

	public ProductRestController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);

	}

	@GetMapping()
	public ResponseEntity<List<Product>> getAllProducts() {

		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}

}
