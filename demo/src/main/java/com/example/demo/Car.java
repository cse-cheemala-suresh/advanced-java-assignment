package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car implements Vechile{
	public Car() {
		System.out.println("Car bean created by spring");
	}

	@Override
	public void run() {
		System.out.println("Car is running......");
		
	}
}
