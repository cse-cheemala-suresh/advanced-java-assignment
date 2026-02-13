package com.capgemini.library_management_hibernate;



import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    	EntityManager em = emf.createEntityManager();
    	
    	try {
    		em.getTransaction().begin();
    		
    		//CREATE(INSERT)
    		Book b1 = new Book(101, "Java Advanced", "C C Cord", "Study", 450.0, "Available", 2023);

            Book b2 = new Book(102, "Spring Boot", "Rod Johnson", "Tech", 550.0, "Issued", 2022);

            Book b3 = new Book(103, "Hibernate Basics", "Gavin King", "ORM", 400.0, "Available", 2021);
    		
    		em.persist(b1);
    		em.persist(b2);
    		em.persist(b3);
    		
    		//Read
    		Book foundBook = em.find(Book.class, 101);
    		
    		System.out.println("Found Book : " + foundBook);
    		
    		List<Book> books = em.createQuery("FROM Book", Book.class).getResultList();

            System.out.println("All Books:");
            books.forEach(System.out::println);
            
    		//UPDATE
    		if(foundBook != null) {
    			foundBook.setAuthorName("C C C Cord");
    			foundBook.setPrice(345.67);
    			em.merge(foundBook);
    			System.out.println("Updated Book : " + foundBook);
    		}
    		
    		//DELETE
    		Book bookToDelete =
                    em.find(Book.class, 101);

            if (bookToDelete != null) {
                em.remove(bookToDelete);
                System.out.println("Deleted Book: " + bookToDelete);
            }
            em.getTransaction().commit();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
			em.close();
			emf.close();
		}
    }
}
