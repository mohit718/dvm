package com.ms.SVM.Controller;

import com.ms.SVM.Entity.Voter;
import com.ms.SVM.Service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @GetMapping
    public List<Voter> getAllVoters() {
        return voterService.getAllVoters();
    }

    @GetMapping("/{id}")
    public Voter getVoterById(@PathVariable Long id) {
        return voterService.getVoterById(id);
    }

    @PostMapping
    public Voter saveVoter(@RequestBody Voter voter) {
        return voterService.saveVoter(voter);
    }

    @DeleteMapping("/{id}")
    public void deleteVoter(@PathVariable Long id) {
        voterService.deleteVoter(id);
    }
}
