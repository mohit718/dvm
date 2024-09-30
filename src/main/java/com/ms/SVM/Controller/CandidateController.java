package com.ms.SVM.Controller;

import com.ms.SVM.Entity.Candidate;
import com.ms.SVM.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
@Secured("ROLE_OFFICER")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    // Get all candidates
    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    // Get a candidate by ID
    @GetMapping("/{id}")
    public Optional<Candidate> getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    // Get candidates by election ID
    @GetMapping("/election/{electionId}")
    public List<Candidate> getCandidatesByElection(@PathVariable Long electionId) {
        return candidateService.getCandidatesByElection(electionId);
    }

    // Create or update a candidate
    @PostMapping
    public Candidate createOrUpdateCandidate(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }

    // Delete a candidate by ID
    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
    }
}

