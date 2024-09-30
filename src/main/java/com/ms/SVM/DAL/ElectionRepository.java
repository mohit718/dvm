package com.ms.SVM.DAL;

import com.ms.SVM.Entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
    // Additional query methods can be defined here
}

