package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
//	public void saveEmployee() {
//		Employee emp1 = new Employee("Suresh", "suresh@gmail.com");
//		Employee emp2 = new Employee("Sohail", "sohail@gmail.com");
//		employeeRepository.save(emp1);
//		employeeRepository.save(emp2);
//	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
