package com.ms.SVM.Service;

import com.ms.SVM.DAL.RoleRepository;
import com.ms.SVM.DAL.UserRepository;
import com.ms.SVM.DTO.LoginUserDto;
import com.ms.SVM.DTO.RegisterUserDto;
import com.ms.SVM.Entity.Role;
import com.ms.SVM.Entity.User;
import com.ms.SVM.Model.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User register(RegisterUserDto input) {
        User user = new User()
            .setRole(roleRepository.findByRoleName(input.getRole()).orElse(roleRepository.findByRoleName(AppRole.ROLE_USER).orElseThrow()))
            .setFullName(input.getFullName())
            .setEmail(input.getEmail())
            .setUsername(input.getUsername())
            .setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getUsername(),
                input.getPassword()
            )
        );

        return userRepository.findByUsername(input.getUsername())
            .orElseThrow();
    }
}
