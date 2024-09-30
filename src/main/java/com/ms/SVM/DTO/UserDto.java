package com.ms.SVM.DTO;

import com.ms.SVM.Entity.Role;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class UserDto {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Role role;

}
