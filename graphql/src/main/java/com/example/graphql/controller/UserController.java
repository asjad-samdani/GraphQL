package com.example.graphql.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.graphql.entity.User;
import com.example.graphql.service.userImple.UserImplement;

@Controller
public class UserController {
  @Autowired
  private UserImplement userImplement;

  // Get all users
  @QueryMapping("getAllUser")
  public ResponseEntity<?> getAllUser() {
    List<User> userDtos = userImplement.getAllUser();
    if (!userDtos.isEmpty()) {
      return new ResponseEntity<>(userDtos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(Map.of("message", "User not found"), HttpStatus.NOT_FOUND);
    }
  }

  @QueryMapping("getUserById")
  public ResponseEntity<?> getOneUser(@Argument Long userId) {
    try {
      User userDto = userImplement.getUserById(userId);
      return new ResponseEntity<>(userDto, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
    }

  }

  @MutationMapping
  public ResponseEntity<?> createUser(@Argument String name, @Argument String email, @Argument String address) {
    User resp = userImplement.creatUser(new User(null, name, email, null, address));
    return new ResponseEntity<>(resp, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    boolean delete = userImplement.deleteById(id);
    if (delete) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.status(404).body("User not found with ID: " + id);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
    User updateUser = userImplement.updateUser(user, id);
    if (updateUser != null) {
      return ResponseEntity.ok(Map.of("message", "Updated successfully"));

    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(Map.of("message", "Question not found or update failed"));

    }

  }

}
