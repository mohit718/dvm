package com.ms.SVM.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "voterId", nullable = false)
    private Voter voter;

    @ManyToOne
    @JoinColumn(name = "electionId", nullable = false)
    private Election election;

    @ManyToOne
    @JoinColumn(name = "candidateId", nullable = false)
    private Candidate candidate;

    private Date timestamp;

}
