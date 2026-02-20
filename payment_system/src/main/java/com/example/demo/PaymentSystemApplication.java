package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PaymentSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PaymentSystemApplication.class, args);
//		BeanFactory bf = context;
		CreditCardPayment c1 = context.getBean(CreditCardPayment.class);
		Payment p1 = context.getBean(Payment.class);
		UpiPayment upi1 = context.getBean(UpiPayment.class);
		
		System.out.println(c1);
		System.out.println(p1);
		System.out.println(upi1);
		
//		Payment p1 = bf.getBean(CreditCardPayment.class);
//		Payment p2 = bf.getBean(Payment.class);
		c1.pay(90);
		p1.pay(190);
		upi1.pay(789.00);
	}

}
