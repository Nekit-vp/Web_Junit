package com.example.Web_Junit.service;

import com.example.Web_Junit.model.User;

import java.util.List;


public interface UserService {

    void create(String login, String password);
    List<User> readAll();
    User read(int id);
    boolean update(User user, int id);
    boolean delete(int id);
    boolean isNotNull(String login);
    boolean check(String login, String password);
    boolean checkConnection();

}
