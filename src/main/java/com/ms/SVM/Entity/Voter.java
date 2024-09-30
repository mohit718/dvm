package com.ms.SVM.Entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voterId;
    private String name;
    private Date dateOfBirth;
    private String address;
    private String email;
    private String phoneNumber;
    private Date registeredDate;
    private String voterStatus;

    @Override
    public AppRole getUserRole() {
        return AppRole.ROLE_VOTER;
    }

}