package com.capgemini.hibernate_many_to_one;

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
		em.getTransaction().begin();
		try {
			Department d1 = new Department("CSE");
			Student s1 = new Student("Suresh", d1);
			Student s2 = new Student("Sohail", d1);
			Student s3 = new Student("DNS", d1);
			em.persist(s1);
			em.persist(s2);
			em.persist(s3);
			
			em.getTransaction().commit();

			System.out.println("Customer and Account saved Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
