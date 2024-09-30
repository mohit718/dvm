package com.ms.SVM.Model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginResponse {
    private String token;
    private long expiresIn;
    public String getToken() {
        return token;
    }
}
