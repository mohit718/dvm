package com.ms.SVM.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.SVM.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}