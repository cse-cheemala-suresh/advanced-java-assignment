package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		ApplicationContext context	 = SpringApplication.run(SpringAppApplication.class, args);
//		BeanFactory bf = context;
		UPIPayment upi = context.getBean(UPIPayment.class);
		Card c = context.getBean(Card.class);
		NetBanking nb = context.getBean(NetBanking.class);
		System.out.println(upi);
		System.out.println(c);
		System.out.println(nb);
		
//		Payment p1 = bf.getBean(UPIPayment.class);
//		Payment p2 = bf.getBean(Card.class);
//		Payment p3 = bf.getBean(NetBanking.class);
		upi.pay();
		c.pay();
		nb.pay();
	}
}
