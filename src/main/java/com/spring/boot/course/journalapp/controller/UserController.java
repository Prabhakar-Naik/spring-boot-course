package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.api.response.WeatherResponse;
import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.UserService;
import com.spring.boot.course.journalapp.service.WeatherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@Tag(name = "User APIs", description = "Read, Update & Delete User")
public class UserController {

    private final UserService userService;
    private final WeatherService weatherService;

    public UserController(UserService userService, WeatherService weatherService) {
        this.userService = userService;
        this.weatherService = weatherService;
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

    @GetMapping(value = "/getWeatherData")
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting = "";
        if (weatherResponse != null) {
            greeting = ", Weather feels like " + weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greeting, HttpStatus.OK);
    }



}
