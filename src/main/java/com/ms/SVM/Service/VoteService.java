package com.ms.SVM.Service;

import com.ms.SVM.DAL.CandidateRepository;
import com.ms.SVM.DAL.ElectionRepository;
import com.ms.SVM.DAL.VoteRepository;
import com.ms.SVM.DAL.VoterRepository;
import com.ms.SVM.Entity.Candidate;
import com.ms.SVM.Entity.Election;
import com.ms.SVM.Entity.Vote;
import com.ms.SVM.Entity.Voter;
import com.ms.SVM.Exception.CandidateNotFoundException;
import com.ms.SVM.Exception.DuplicateVoteException;
import com.ms.SVM.Exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private ElectionRepository electionRepository;

    // Get all votes
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    // Get vote by ID
    public Optional<Vote> getVoteById(Long id) {
        return voteRepository.findById(id);
    }

    // Cast a vote
    public Vote castVote(Vote vote) {
        Long voterId = vote.getVoter().getVoterId();
        Long candidateId = vote.getCandidate().getCandidateId();
        Long electionId = vote.getElection().getElectionId();

        Voter voter = voterRepository.findById(voterId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid voter"));
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid candidate"));
        Election election = electionRepository.findById(electionId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid election"));

        List<Vote> existingVotes = voteRepository
                .findByElection_ElectionIdAndVoter_VoterId(election.getElectionId(), voter.getVoterId());
        if (existingVotes.size() > 0)
            throw new DuplicateVoteException(voter.getName() + " already voted in this election.");
        if (!election.getCandidates().contains(candidate))
            throw new CandidateNotFoundException(candidate.getName() + " doesn't exist in this election.");

        return voteRepository.save(vote);
    }

    // Get votes by election
    public List<Vote> getVotesByElection(Long electionId) {
        return voteRepository.findByElection_ElectionId(electionId); // Assuming you have this query method
    }

    // Count votes for a candidate
    public Long countVotesForCandidate(Long candidateId) {
        return voteRepository.countByCandidate_CandidateId(candidateId); // Assuming you have this query method
    }

    // Delete a vote by ID
    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }
}
