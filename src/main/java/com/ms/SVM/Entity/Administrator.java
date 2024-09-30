package com.ms.SVM.Entity;

import com.ms.SVM.Model.AppRole;
import com.ms.SVM.Model.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Administrator implements UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String name;
    private String email;
    private String phoneNumber;

    @Override
    public AppRole getUserRole() {
        return AppRole.ROLE_ADMIN;
    }
}

