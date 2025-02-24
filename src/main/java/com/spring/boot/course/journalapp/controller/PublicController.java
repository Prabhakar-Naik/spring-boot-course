package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.model.UserLoginRequest;
import com.spring.boot.course.journalapp.service.JournalEntryService;
import com.spring.boot.course.journalapp.service.UserDetailsServiceImpl;
import com.spring.boot.course.journalapp.service.UserService;
import com.spring.boot.course.scedular.UserScheduler;
import com.spring.boot.course.utils.JwtUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/public")
@Tag(name = "Public APIs")
public class PublicController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private UserScheduler userScheduler;

    @GetMapping(value = "/health-check")
    public String healthcheck() {
        return "OK";
    }


    @GetMapping("/fetchMails")
    public void fetchMails(){
        this.userScheduler.fetchUsersAndSendSaMail();
    }


    @PostMapping(value = "/signup")
    public String signup(@RequestBody User user) {
        return this.userService.save(user);
    }

    // login
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUserName(), user.getPassword()));
            UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(user.getUserName());
            String jwt = jwtUtils.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (AuthenticationException e) {
            //log.info("Exception: {}", e.getMessage());
            return new ResponseEntity<>("Invalid username or password", HttpStatus.BAD_REQUEST);
        }
    }

    // forgot password

    // reset password

    //
}
