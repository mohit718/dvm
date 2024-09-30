package com.ms.SVM.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoleNotFoundException  extends RuntimeException {
    public RoleNotFoundException() {
        super("Role not found.");
    }
    public RoleNotFoundException(String message) {
        super(message);
    }
}