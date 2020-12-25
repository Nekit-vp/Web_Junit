package com.example.Web_Junit.repository;

import com.example.Web_Junit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
}
