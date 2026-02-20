package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Bike implements Vechile{
	public Bike() {
		System.out.println("Bike bean is created by spring");
	}

	@Override
	public void run() {
		System.out.println("Bike is running......");
		
	}
}

