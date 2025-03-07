package com.ms.SVM.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.SVM.Model.AppRole;
import com.ms.SVM.Model.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Officer implements UserType {
    @Id
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @JsonBackReference
    private User userDetails;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "electionId", nullable = false)
    private Election election;

    @Override
    public AppRole getUserRole() {
        return AppRole.ROLE_OFFICER;
    }
}
