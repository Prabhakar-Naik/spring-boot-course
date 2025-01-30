package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }


    @PostMapping(value = "/createUser")
    public String createUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }


    @PutMapping(value = "/updateUser/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName) {
        return this.userService.updateUser(user, userName);
    }


    @GetMapping(value = "/getUserByUserName/{userName}")
    public ResponseEntity<?> getUserByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(this.userService.getUserByName(userName));
    }


}
