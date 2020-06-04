package com.so.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.so.authservice.data.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String username);
}
