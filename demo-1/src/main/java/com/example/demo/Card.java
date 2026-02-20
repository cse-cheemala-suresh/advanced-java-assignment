package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Card implements Payment{
	public Card() {
		System.out.println("Card  bean created");
	}

	@Override
	public void pay() {
		System.out.println("Card Payment in Progress");
		
	}
}
