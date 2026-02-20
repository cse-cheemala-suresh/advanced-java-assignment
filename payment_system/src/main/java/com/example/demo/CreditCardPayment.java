package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("singleton")
public class CreditCardPayment implements Payment{
	
	public CreditCardPayment() {
		System.out.println("CreditCardPayment bean Created");
	}

	@Override
	public void pay(double payment) {
		System.out.println("Credit card payment of Rs. " + payment + " successfull");
	}

}
