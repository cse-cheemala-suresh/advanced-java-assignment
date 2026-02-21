package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PaymentSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PaymentSystemApplication.class, args);
		CreditCardPayment c1 = context.getBean(CreditCardPayment.class);
		Payment p1 = context.getBean(Payment.class);
		UpiPayment upi1 = context.getBean(UpiPayment.class);
		UpiPayment upi2 = context.getBean(UpiPayment.class);
		
		System.out.println(c1);
		System.out.println(p1);
		System.out.println(upi1);
		System.out.println(upi2);
		
		c1.pay(90);
		p1.pay(190);
		upi1.pay(789.00);
		upi1.pay(7890.00);
		
		((ConfigurableApplicationContext) context).close();
	}

}
