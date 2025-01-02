package com.example.graphql.service.userImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.entity.User;
import com.example.graphql.repo.UserRepo;
import com.example.graphql.service.UserService;

@Service
public class UserImplement implements UserService {
  @Autowired
  private UserRepo userRepo;
  // @Autowired
  // private ObjectMapper objectMapper;

  @Override
  public User creatUser(User user) {
    return userRepo.save(user);

  }

  // @Override
  // public List<UserDto> getAllUser() {
  // List<User> users = userRepo.findAll();
  // return users.stream()
  // .map(user -> objectMapper.convertValue(user, UserDto.class)).toList();

  // }

  @Override
  public List<User> getAllUser() {
    return userRepo.findAll();
  }
  // @Override
  // public UserDto getUserById(Long id) {
  // User users = userRepo.findById(id).orElseThrow(() -> new
  // RuntimeException("User not found with ID: " + id));
  // return objectMapper.convertValue(users, UserDto.class);

  // }

  // }
  @Override
  public User getUserById(Long id) {
    return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
  }
}