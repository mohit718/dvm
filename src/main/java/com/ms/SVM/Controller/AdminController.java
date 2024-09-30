package com.ms.SVM.Controller;

import com.ms.SVM.DTO.UserDto;
import com.ms.SVM.Entity.User;
import com.ms.SVM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
//    @Secured("ROLE_ADMIN")
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping("/update-role")
    public ResponseEntity<String> updateUserRole(@RequestParam Long userId,@RequestParam String roleName){
        userService.updateUserRole(userId, roleName);
        return new ResponseEntity<>("User role updated.", HttpStatus.OK);
    }


}
