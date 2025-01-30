package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String saveUser(User user) {
        if (this.userRepository.findByUserName(user.getUserName()) != null) {
            return "User already exists";
        }
        return userRepository.save(user).getUserName()+" registered Successfully";
    }

    public ResponseEntity<?> updateUser(User user, String username) {
        User userInDB = this.userRepository.findByUserName(username);
        if (userInDB != null) {
            userInDB.setUserName(user.getUserName());
            userInDB.setPassword(user.getPassword());
            this.userRepository.save(userInDB);
            return ResponseEntity.ok("Updated");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<User> getUserByName(String userName) {
        User user = this.userRepository.findByUserName(userName);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
