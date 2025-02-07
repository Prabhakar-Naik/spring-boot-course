package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.JournalEntryService;
import com.spring.boot.course.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/public")
public class PublicController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/health-check")
    public String healthcheck() {
        return "OK";
    }

    @PostMapping(value = "/createUser")
    public String createUser(@RequestBody User user) {
        return this.userService.save(user);
    }

    // login

    // forgot password

    // reset password

    //
}
