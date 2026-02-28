package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee")
@Data
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;
	
	private String name;
	
	private String email;
	
	private String department;
	
	@Column(name = "joining_date")
	private LocalDate joiningDate;

	public Employee(String name, String email, String department, LocalDate joiningDate) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.joiningDate = joiningDate;
	}
	
}
