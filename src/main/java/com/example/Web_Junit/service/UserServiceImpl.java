package com.example.Web_Junit.service;

import com.example.Web_Junit.model.User;
import com.example.Web_Junit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;




    @Override
    public void create(String login, String password) {
        userRepository.save(new User(login, password));
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public boolean update(User user, int id) {
        if (userRepository.existsById(id)){
            user.setId(id);
            userRepository.save(user);
            return true;

        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean isNotNull(String login){
        User user = userRepository.findByLogin(login);
        return user != null;
    }

    @Override
    public boolean check(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user != null)
            return user.getLogin().equals(login) && user.getPassword().equals(password);
        return false;
    }

    @Override
    public boolean checkConnection(){
        return userRepository != null;
    }
}
