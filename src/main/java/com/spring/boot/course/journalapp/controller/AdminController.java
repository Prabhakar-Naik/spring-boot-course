package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.cache.AppCache;
import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    private AppCache appCache;

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

    @GetMapping("clear-app-cache")
    public void clearAppCache(){
        appCache.init();
    }


}
