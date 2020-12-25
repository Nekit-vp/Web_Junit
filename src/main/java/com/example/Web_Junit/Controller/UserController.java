package com.example.Web_Junit.Controller;


import com.example.Web_Junit.model.User;
import com.example.Web_Junit.service.UserService;
import com.example.Web_Junit.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HostnameVerifier;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody User user){
        userService.create(user.getLogin(), user.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> read(){
        final List<User> users = userService.readAll();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> read(@PathVariable(name = "id") int id){
        final User log = userService.read(id);
        return log != null
                ? new ResponseEntity<>(log, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody User user){
        final boolean update = userService.update(user, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
