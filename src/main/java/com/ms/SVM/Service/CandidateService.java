package com.ms.SVM.Service;

import com.ms.SVM.DAL.CandidateRepository;
import com.ms.SVM.Entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    // Get all candidates
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // Get candidate by ID
    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    // Get candidates by Election
    public List<Candidate> getCandidatesByElection(Long electionId) {
        return candidateRepository.findByElection_ElectionId(electionId); // Assuming you have this query method
    }

    // Create or update candidate
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    // Delete candidate by ID
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}

