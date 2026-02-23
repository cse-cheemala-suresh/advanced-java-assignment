package com.springmvc.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.demo.dao.ProductDao;
import com.springmvc.demo.model.Product;

@Service
public class ProductService {
	ProductDao productDao;	
	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}
	public List<Product> fetchProducts(){
		return productDao.getAllProducts();
	}
}