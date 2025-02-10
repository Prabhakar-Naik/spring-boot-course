package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
//@Slf4j        // framework annotation
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // we must use private access modifier for access and assigning the object within the class.
    // static keyword to access anywhere in the class.
    // must and should final keyword for do not creating duplicate or more than 1 instance.

    // LoggerFactory is a utility class .getLogger() is a method which is re-present one specific class logs
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
                //.orElseThrow(() -> new UsernameNotFoundException("User Not Found "+ username));
        if (user != null) {
            logger.info("User found with username: {}", username);
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
        }
        logger.info("User not found with username: {}", username);
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

}
