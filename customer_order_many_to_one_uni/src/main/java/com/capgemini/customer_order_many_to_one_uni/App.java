package com.capgemini.customer_order_many_to_one_uni;

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
			
			Customer c1 = new Customer("Suresh","suresh@gmail.com");
			Customer c2 = new Customer("Naga", "naga@gmail.com");
			Order o1 = new Order("12-2-2026", 345.56, c1);
			Order o2 = new Order("12-3-2026", 23.22, c1);
			Order o3 = new Order("11-2-2026", 456.00, c2);
			
			em.persist(o1);
			em.persist(o2);
			em.persist(o3);
			
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
