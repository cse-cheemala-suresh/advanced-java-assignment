package com.capgemini.hibernate_one_to_one;

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
		//create entity manager factory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		
		//create entity manager
		EntityManager em = emf.createEntityManager();
		
		//begin transaction
		em.getTransaction().begin();
		//create objects
		Account account = new Account("ACC12345", "Savings");
		Customer customer = new Customer("John Doe", account);
		//set bidirectional relationship
		account.setCustomer(customer);
		//persist customer (account will also persist if cascade is used)
		em.persist(customer);
		//read
//		Customer foundCustomer = em.find(Customer.class, 1l);
//		System.out.println("Found Book : " + foundCustomer);
//		
//		List<Customer> books = em.createQuery("FROM Customer", Customer.class).getResultList();
//
//        System.out.println("All Customers:");
//        books.forEach(System.out::println);
//        //Update
//        if(foundCustomer != null) {
//			foundCustomer.setName("C Cord");
//			System.out.println("Updated Customer : " + foundCustomer);
//		}
//		//Delete
//        Customer customerToDelete =
//                em.find(Customer.class, 1l);
//
//        if (customerToDelete != null) {
//            em.remove(customerToDelete);
//            System.out.println("Deleted Customer: " + customerToDelete);
//        }
//		//commit transaction
		em.getTransaction().commit();
		System.out.println("Customer and Account saved successfully!");
	}
}
