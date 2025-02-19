package com.ms.SVM.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @JsonBackReference
    private User userDetails;
    
    private String partyAffiliation;

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
