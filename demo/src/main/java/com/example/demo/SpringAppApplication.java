package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringAppApplication.class, args);
		Car c1 = context.getBean(Car.class);
		Car c2 = context.getBean(Car.class);
		System.out.println(c1);
		System.out.println(c2);
		
		Vechile vechile1 = context.getBean(Car.class);
		Vechile vechile2 = context.getBean(Bike.class);
		vechile1.run();
		vechile2.run();
	}
}