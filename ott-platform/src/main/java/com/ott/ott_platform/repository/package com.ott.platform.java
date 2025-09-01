package com.ott.platform.repository;

import com.ott.platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom method to find a user by email
    User findByEmail(String email);

}