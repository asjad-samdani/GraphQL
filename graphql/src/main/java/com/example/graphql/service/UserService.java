package com.example.graphql.service;

import java.util.List;

import com.example.graphql.entity.User;

public interface UserService {
  // create
  User creatUser(User user);

  // get all
  List<User> getAllUser();

  // get by id
  User getUserById(Long id);
  // update

  User updateUser(User user, Long id);

  // delete
  boolean deleteById(Long id);

}
