package com.ms.SVM.Entity;

import com.ms.SVM.Model.AppRole;
import com.ms.SVM.Model.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
public class Candidate implements UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;
    private String name;
    private String partyAffiliation;
    private String bio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "electionId", nullable = false)
    private Election election;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Vote> votes;

    @Override
    public AppRole getUserRole() {
        return AppRole.ROLE_CANDIDATE;
    }
}
