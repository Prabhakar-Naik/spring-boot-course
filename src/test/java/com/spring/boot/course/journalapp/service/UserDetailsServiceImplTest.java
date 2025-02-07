package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.mockito.Mockito.*;

//@SpringBootTest
public class UserDetailsServiceImplTest {

    // if you want to run the application in Spring Boot Context do the below code format
    // place the @SpringBootTest on top of this class
    // here the SpringBootContext preparing all instances and inject for data manipulation

    /*
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockitoBean
    private UserRepository userRepository;
    */

    // if you don't want to be run the application in Spring Boot Context instead of simple
    // Mockito test do the below format
    // here the Mockito inject the dependencies as well instances with dump dependencies
    // so we place @InjectMocks, @Mock

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;
    // above @InjectMocks automatically injecting the dump instance

    @Mock
    private UserRepository userRepository;

    // it will initialize the dump repository on UserRepository.
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void loadUserByUsernameTest() {
        User user = new User();
        user.setUserName("prabhakar");
        user.setPassword("password");
        user.setRoles(List.of("USER"));
        when(this.userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(user);
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername("prabhakar");
        System.out.println(userDetails.toString());
    }
}
