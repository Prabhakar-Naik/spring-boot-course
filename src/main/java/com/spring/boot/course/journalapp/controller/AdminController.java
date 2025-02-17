package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.cache.AppCache;
import com.spring.boot.course.journalapp.entity.ConfigJournalAppEntity;
import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.ConfigService;
import com.spring.boot.course.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    private final UserService userService;
    private final ConfigService configService;

    @Autowired
    private AppCache appCache;

    public AdminController(UserService userService, ConfigService configService) {
        this.userService = userService;
        this.configService = configService;
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

    @PostMapping(value = "/saveCredentials")
    public String saveCredentials(@RequestBody ConfigJournalAppEntity entity){
        return this.configService.saveCredentials(entity);
    }

    @GetMapping(value = "/getCredentials")
    public List<ConfigJournalAppEntity> getCredentials() {
        return this.configService.getAll();
    }




}
