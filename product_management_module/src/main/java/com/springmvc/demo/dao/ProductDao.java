package com.springmvc.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.demo.model.Product;

@Repository
public class ProductDao {
	public List<Product> getAllProducts(){
		Product p1 = new Product(101, "Laptop", 2459.00);
		Product p2 = new Product(102, "Mobile", 245.00);
		Product p3 = new Product(103, "Monitor", 459.00);
		List<Product> productList = new ArrayList<>();
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		return productList;
	}
}
