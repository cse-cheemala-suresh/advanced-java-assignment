package com.capgemini.email_management_system;


import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username", nullable = false)
    private String username;

    // ✅ ElementCollection for Set<String>
    @ElementCollection
    @CollectionTable(
        name = "user_emails",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "email")
    private Set<String> emails;

    // Mandatory no-arg constructor
    public User() {}

    // Getters & Setters
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }
}

