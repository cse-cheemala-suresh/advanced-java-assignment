package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private Long contactNumber;
	private String address;
	public Customer(String name, String email, Long contactNumber, String address) {
		super();
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
}
