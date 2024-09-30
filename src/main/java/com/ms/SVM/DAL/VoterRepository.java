package com.ms.SVM.DAL;

import com.ms.SVM.Entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {
    // Additional query methods can be defined here
}

