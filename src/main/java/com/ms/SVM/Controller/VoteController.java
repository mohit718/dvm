package com.ms.SVM.Controller;

import com.ms.SVM.Entity.Vote;
import com.ms.SVM.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    // Get all votes
    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    // Get a vote by ID
    @GetMapping("/{id}")
    public Optional<Vote> getVoteById(@PathVariable Long id) {
        return voteService.getVoteById(id);
    }

    // Cast a vote
    @PostMapping
    public Vote castVote(@RequestBody Vote vote) {
        return voteService.castVote(vote);
    }

    // Get votes by election ID
    @GetMapping("/election/{electionId}")
    public List<Vote> getVotesByElection(@PathVariable Long electionId) {
        return voteService.getVotesByElection(electionId);
    }

    // Count votes for a candidate by ID
    @GetMapping("/candidate/{candidateId}/count")
    public Long countVotesForCandidate(@PathVariable Long candidateId) {
        return voteService.countVotesForCandidate(candidateId);
    }

    // Delete a vote by ID
    @DeleteMapping("/{id}")
    public void deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
    }
}
