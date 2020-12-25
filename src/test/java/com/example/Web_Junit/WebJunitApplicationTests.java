package com.example.Web_Junit;

import com.example.Web_Junit.model.User;
import static org.junit.Assert.*;

import com.example.Web_Junit.repository.UserRepository;
import com.example.Web_Junit.service.UserService;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class WebJunitApplicationTests {

    @Autowired
    public UserService userService;

    @Test
    public void testIsValidLoginAndPassword() {
        boolean isValid = User.isValid(null, "123456");
        assertFalse(isValid);
    }

    @Test
    public void testIsValidLoginAndPassword2(){
        boolean isValid = User.isValid("", "nikita");
        assertFalse(isValid);
    }

    @Test
    public void testIsValidLoginAndPassword3(){
        boolean isValid = User.isValid("nikita", "1234");
        assertTrue(isValid);
    }

    @Test
    public void testIsValidLoginAndPassword4(){
        boolean isValid = User.isValid("nikita", "1234");
        assertTrue(isValid);
    }

    @Test
    public void testUserInBD(){
        boolean exist = userService.isNotNull("1");
        assertTrue(exist);
    }

    @Test
    public void testUserInBD2(){
        boolean exist = userService.isNotNull("1235562sdfasdfasdf");
        assertFalse(exist);
    }

    @Test
    public void testBD(){
        boolean connection = userService.checkConnection();
        assertTrue(connection);
    }

    @Test
    public void addUserInBd(){
        User user = new User("okwkkff", "123");
        userService.create(user.getLogin(), user.getPassword());
        boolean exist = userService.isNotNull(user.getLogin());

        List<User> list = userService.readAll();
        for (User us :
                list) {
            if(us.getLogin().equals("okwkkff")) {
                userService.delete(us.getId());
            };
        }
        assertTrue(exist);
    }



}
