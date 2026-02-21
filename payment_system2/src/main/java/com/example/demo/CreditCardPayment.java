package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Primary
@Scope("singleton")
public class CreditCardPayment implements Payment{
	
	public CreditCardPayment() {
		System.out.println("CreditCardPayment bean Created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("CreditCardPayment bean initialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("CreditCardPayment bean destroyed");
	}
	
	@Override
	public void pay(double payment) {
		System.out.println("Credit card payment of Rs. " + payment + " successfull");
	}

}
