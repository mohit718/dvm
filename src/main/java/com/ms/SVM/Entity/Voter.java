package com.ms.SVM.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ms.SVM.Model.AppRole;
import com.ms.SVM.Model.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Voter implements UserType {

    @Id
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @JsonBackReference
    private User userDetails;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private Date registeredDate;
    private String voterStatus;

    @Override
    public AppRole getUserRole() {
        return AppRole.ROLE_VOTER;
    }

}