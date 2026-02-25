package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {
	private CustomerService customerservice;
	
	public CustomerController(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	
	@GetMapping("/customer")
	public String getCustomer(Model model) {
		List<Customer> customers = customerservice.getCustomerDetails();
		model.addAttribute("customers", customers);
		return "customer";
	}
	
	@GetMapping("/addCustomer")
	public String showAddForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {
		customerservice.saveCustomer(customer);
		return "redirect:/customer";
	}
}
