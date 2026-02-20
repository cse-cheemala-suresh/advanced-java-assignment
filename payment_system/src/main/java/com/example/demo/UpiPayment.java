package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements Payment{
	
	public UpiPayment() {
		System.out.println("UpiPayment bean Created");
	}

	@Override
	public void pay(double payment) {
		System.out.println("UPI payment of Rs. " + payment + " successfull");
	}

}
