package com.capgemini.hibernate_many_to_one_bidi;

import java.util.List;

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
			DepartmentBidi d1 = new DepartmentBidi("CSE");
			StudentBidi s1 = new StudentBidi("Suresh", d1);
			StudentBidi s2 = new StudentBidi("Sohail", d1);
			StudentBidi s3 = new StudentBidi("DNS", d1);
			d1.setStudent(List.of(s1, s2, s3));
			em.persist(d1);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
