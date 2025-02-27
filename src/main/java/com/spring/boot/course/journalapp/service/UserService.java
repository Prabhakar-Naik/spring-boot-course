package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.dtos.UserDTO;
import com.spring.boot.course.journalapp.entity.ResetToken;
import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.repository.ResetTokenRepository;
import com.spring.boot.course.journalapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ResetTokenRepository resetTokenRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ResetTokenRepository resetTokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.resetTokenRepository = resetTokenRepository;
    }

    public boolean saveNewUser(UserDTO userDTO) {
        try {
            User user = new User();
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setRoles(List.of("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public void saveAdmin(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList("USER", "ADMIN"));
//        userRepository.save(user);
//    }

    public String save(UserDTO userDTO) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(List.of("USER"));
        if (this.userRepository.findByUserName(userDTO.getUserName()) != null) {
            return "User already exists";
        }
        return userRepository.save(user).getUserName() + " registered Successfully";
    }

    public String saveAdmin(UserDTO userDTO) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(List.of("USER","ADMIN"));
        if (this.userRepository.findByUserName(userDTO.getUserName()) != null) {
            return "User already exists";
        }
        return userRepository.save(user).getUserName() + " registered Successfully";
    }

    public void saveUser(User user) {
        User byUserName = this.userRepository.findByUserName(user.getUserName());
        if ( byUserName != null) {
            userRepository.save(user);
        }
    }

    public String forgotPassword(String email) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            String token = passwordEncoder.encode(UUID.randomUUID().toString());
            ResetToken resetToken = new ResetToken(token, userOpt.get());
            resetToken.setId(UUID.randomUUID().toString());
            resetTokenRepository.save(resetToken);
            return "Password reset token generated: " + token;
        }
        return "Email not found";
    }

    public String resetPassword(String token, String newPassword) {
        Optional<ResetToken> resetTokenOpt = resetTokenRepository.findByToken(token);
        if (resetTokenOpt.isPresent()) {
            User user = resetTokenOpt.get().getUser();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            resetTokenRepository.delete(resetTokenOpt.get());
            return "Password reset successfully";
        }
        return "Invalid or expired token";
    }



    public ResponseEntity<?> updateUser(UserDTO user, String username) {
        User userInDB = this.userRepository.findByUserName(username);
        if (userInDB != null) {
            userInDB.setUserName(user.getUserName());
            userInDB.setEmail(user.getEmail());
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
        logger.info("Get all users");
        return userRepository.findAll();
    }


    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public String deleteById(String id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                userRepository.delete(user.get());
                return "Deleted Successfully";
            }else
                return "User Not Found with --> "+ id;
        }catch (Exception e) {
           return e.getMessage();
        }
    }


}
