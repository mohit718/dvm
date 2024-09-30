package com.ms.SVM.Service;

import com.ms.SVM.DAL.ElectionRepository;
import com.ms.SVM.Entity.Election;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ElectionService {

    @Autowired
    private ElectionRepository electionRepository;

    // Get all elections
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    // Get election by ID
    public Optional<Election> getElectionById(Long id) {
        return electionRepository.findById(id);
    }

    // Create or update election
    public Election saveElection(Election election) {
        return electionRepository.save(election);
    }

    // Delete election by ID
    public void deleteElection(Long id) {
        electionRepository.deleteById(id);
    }

    // Additional methods can be added as per business requirements
}

