package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> getCustomerDetails(){
		return customerRepository.findAll();
	}
}
