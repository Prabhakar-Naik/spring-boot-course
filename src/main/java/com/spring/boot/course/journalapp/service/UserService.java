package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public boolean saveNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("hahahhahhahahahah");
            log.warn("hahahhahhahahahah");
            log.info("hahahhahhahahahah");
            log.debug("hahahhahhahahahah");
            log.trace("hahahhahhahahahah");
            return false;
        }
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }*/

    public String save(User user) {
        user.setId(UUID.randomUUID().toString());
        if (this.userRepository.findByUserName(user.getUserName()) != null) {
            return "User already exists";
        }
        return userRepository.save(user).getUserName() + " registered Successfully";
    }

    public String saveUser(User user) {
        User byUserName = this.userRepository.findByUserName(user.getUserName());
        if ( byUserName != null) {
            userRepository.save(user);
            return "User exists";
        }
        return "Not Updated.";
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

    public User getUserByName(String userName) {
        User user = this.userRepository.findByUserName(userName);
        if (user != null) {
            return userRepository.findByUserName(userName);
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }


}
