package com.ms.SVM.DTO;

import com.ms.SVM.Model.AppRole;
import com.ms.SVM.Model.UserType;
import lombok.Data;

@Data
public class RegisterUserDto {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private AppRole role;
}
