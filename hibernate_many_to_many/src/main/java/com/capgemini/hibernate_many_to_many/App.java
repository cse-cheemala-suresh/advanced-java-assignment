package com.capgemini.hibernate_many_to_many;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			Project p1 = new Project("Library Management");
			Project p2 = new Project("Insurance System");
			
			Set<Project> proSet = new HashSet<>();
			
			proSet.add(p1);
			proSet.add(p2);
			
			Employee e1 = new Employee("John", proSet);
			Employee e2 = new Employee("Mark", proSet);
			
			Set<Employee> emp = new HashSet<>();
			
			emp.add(e1);
			emp.add(e2);
			
			p1.setEmployee(emp);
			p2.setEmployee(emp);
			
			em.persist(e1);
			em.persist(e2);
			
			em.getTransaction().commit();
			
			System.out.println("Done");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
