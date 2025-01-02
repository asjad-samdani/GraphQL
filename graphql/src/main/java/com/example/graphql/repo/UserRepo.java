package com.example.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
