package com.ms.SVM.DAL;

import com.ms.SVM.Entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByElection_ElectionId(Long electionId);
}

