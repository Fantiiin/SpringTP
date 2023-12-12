package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer> {

    User findById(String author);
}