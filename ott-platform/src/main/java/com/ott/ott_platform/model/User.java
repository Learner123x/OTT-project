package com.ott.platform.model;

import jakarta.persistence.*;
import lombok.Data; // From Lombok, if you added it
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // Marks this class as a JPA entity
@Table(name = "users") // Specifies the table name in the database
@Data // Lombok: Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok: Generates a no-argument constructor
@AllArgsConstructor // Lombok: Generates a constructor with all arguments
public class User {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private Long id;

    @Column(nullable = false, unique = true) // Ensures username is not null and is unique
    private String username;

    @Column(nullable = false) // Ensures password is not null
    private String password; // In a real app, this would be hashed and salted!

    @Column(nullable = false, unique = true) // Ensures email is not null and is unique
    private String email;

    // You can add more fields later, e.g., registrationDate, lastLogin, roles etc.
}