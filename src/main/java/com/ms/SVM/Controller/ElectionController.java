package com.ms.SVM.Controller;

import com.ms.SVM.Entity.Election;
import com.ms.SVM.Service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elections")
@Secured("ROLE_OFFICER")
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    // Get all elections
    @GetMapping
    public List<Election> getAllElections() {
        return electionService.getAllElections();
    }

    // Get an election by ID
    @GetMapping("/{id}")
    public Optional<Election> getElectionById(@PathVariable Long id) {
        return electionService.getElectionById(id);
    }

    // Create or update an election
    @PostMapping
    public Election createOrUpdateElection(@RequestBody Election election) {
        System.out.println(election);
        return electionService.saveElection(election);
    }

    // Delete an election by ID
    @DeleteMapping("/{id}")
    public void deleteElection(@PathVariable Long id) {
        electionService.deleteElection(id);
    }
}
