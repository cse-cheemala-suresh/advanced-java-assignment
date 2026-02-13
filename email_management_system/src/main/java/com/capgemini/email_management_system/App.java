package com.capgemini.email_management_system;

/**
 * Hello world!
 *
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        try {
            // Create User
            User user = new User();
            user.setUsername("John");

            // Create email Set
            Set<String> emails = new HashSet<>();
            emails.add("john@gmail.com");
            emails.add("john.work@gmail.com");
            emails.add("john@gmail.com"); // duplicate ignored

            user.setEmails(emails);

            // Persist
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

            System.out.println("User saved successfully!");

            // Fetch user
            User fetchedUser = em.find(User.class, user.getUserId());
            System.out.println("User Name: " + fetchedUser.getUsername());
            System.out.println("Emails: " + fetchedUser.getEmails());

        } finally {
            em.close();
            emf.close();
        }
    }
}
