package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NetBanking implements Payment{
	public NetBanking() {
		System.out.println("Net Banking bean created");
	}

	@Override
	public void pay() {
		System.out.println("Net banking Payment in Progress");
		
	}
}
