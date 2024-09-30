package com.ms.SVM.DAL;

import com.ms.SVM.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByElection_ElectionId(Long electionId);

    Long countByCandidate_CandidateId(Long candidateId);

    List<Vote> findByElection_ElectionIdAndVoter_VoterId(Long ElectionId, Long VoterId);
}
