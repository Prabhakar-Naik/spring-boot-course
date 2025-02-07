package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/createAdmin")
    public String createUser(@RequestBody User user) {
        return this.userService.saveAdmin(user);
    }


    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }



}
