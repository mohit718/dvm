package com.ms.SVM.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long electionId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String electionStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL)
    private List<Candidate> candidates;

    @JsonIgnore
    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL)
    private List<Vote> votes;

}
