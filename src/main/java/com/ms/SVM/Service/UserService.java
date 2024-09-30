package com.ms.SVM.Service;

import com.ms.SVM.DAL.RoleRepository;
import com.ms.SVM.DAL.UserRepository;
import com.ms.SVM.DTO.UserDto;
import com.ms.SVM.Entity.Role;
import com.ms.SVM.Entity.User;
import com.ms.SVM.Exception.RoleNotFoundException;
import com.ms.SVM.Model.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public void updateUserRole(Long userId, String roleName){
        User user = userRepository.findById(userId).orElseThrow(()->new UsernameNotFoundException("User with id "+userId+" not found."));
        AppRole appRole = AppRole.valueOf(roleName);
        Role role = roleRepository.findByRoleName(appRole).orElseThrow(()->new RoleNotFoundException("Role "+appRole+" not found."));
        user.setRole(role);
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public UserDto getUserById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new UsernameNotFoundException("User with id "+userId+" not found."));
        return new UserDto()
            .setUserId(user.getUserId())
            .setUsername(user.getUsername())
            .setFullName(user.getFullName())
            .setRole(user.getRole())
            .setCreatedDate(user.getCreatedDate())
            .setUpdatedDate(user.getUpdatedDate());
    }
}
