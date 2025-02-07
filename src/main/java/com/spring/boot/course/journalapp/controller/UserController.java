package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(value = "/updateUser/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return this.userService.updateUser(user, userName);
    }


    @GetMapping(value = "/getUserByUserName/{userName}")
    public ResponseEntity<?> getUserByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(this.userService.getUserByName(userName));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        String response = this.userService.deleteById(id);
        return ResponseEntity.ok(response);
    }



}
