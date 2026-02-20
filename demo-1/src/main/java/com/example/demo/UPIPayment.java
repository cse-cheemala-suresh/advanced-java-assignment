package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UPIPayment implements Payment{
	public UPIPayment() {
		System.out.println("UPIPayment bean created");
	}

	@Override
	public void pay() {
		System.out.println("UPI Payment in Progress");
		
	}
}
