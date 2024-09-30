package com.ms.SVM.Service;

import com.ms.SVM.DAL.VoterRepository;
import com.ms.SVM.Entity.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Voter getVoterById(Long id) {
        return voterRepository.findById(id).orElse(null);
    }

    public Voter saveVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public void deleteVoter(Long id) {
        voterRepository.deleteById(id);
    }
}

