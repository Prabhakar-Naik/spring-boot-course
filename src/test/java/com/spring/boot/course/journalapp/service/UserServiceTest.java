package com.spring.boot.course.journalapp.service;


import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Initialization process
        System.out.println("Before All");
    }

    @BeforeEach
    public void beforeEach(){
        // every time run before every method
        System.out.println("Running before method");
    }

    @AfterEach
    public void afterEach(){
        // every time execute this after every method
        System.out.println("Running after method");
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        System.out.println("After All");
    }

    @Disabled
    @Test
    public void normalTest(){
        assertEquals(2,1+1);       // pass
        //assertEquals(3, 2+2);      // fail
        assertNotNull("This is Not Null");  // pass
        //assertNotNull(null);                // fail
        assertTrue(true);                // pass
        //assertTrue(false);               // fail
        assertFalse(false);              // pass
        //assertFalse(true);               // fail
    }

    @Disabled
    @Test
    public void testOnCountRecords(){
        assertEquals(3, userRepository.count());
    }


    @Disabled
    @Test
    public void testFindByUsername() {
        //assertEquals(4, 2+2);
        User user = this.userRepository.findByUserName("prabhakar");
        assertNotNull(user);
        assertTrue(!user.getJournalEntries().isEmpty());
    }


    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            //"3,3,9"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a+b);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource(value = {
            "prabhakar",
            "prabha",
            "admin",
            //"sudhakar"
    })
    public void testFindByUserName(String username) {
        assertNotNull(this.userRepository.findByUserName(username));
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "prabhakar",
            "prabha",
            "admin",
            //"sudhakar"
    })
    public void testFindByUserName2(String userName){
        assertNotNull(this.userRepository.findByUserName(userName));
    }

    enum Names{
        prabhakar,
        prabha,
        admin,
       // sudhakar
    }

    @Disabled
    @ParameterizedTest
    @EnumSource(Names.class)
    public void testFindByUserName3(Names userName){
        assertNotNull(userRepository.findByUserName(userName.toString()));
    }


    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(this.userService.saveNewUser(user));
    }

}

