package com.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.demo.service.ProductService;

@Controller
public class ProductController {
	ProductService productService;
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/products")
	public String products(Model model) {
//		List<Product> products = productService.fetchProducts();
		model.addAttribute("products", productService.fetchProducts());
		return "products";
	}
}
