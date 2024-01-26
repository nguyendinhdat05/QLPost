package com.example.qlpost.repository;

import com.example.qlpost.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    User findByUsernameAndPassword(String username, String password);
}
