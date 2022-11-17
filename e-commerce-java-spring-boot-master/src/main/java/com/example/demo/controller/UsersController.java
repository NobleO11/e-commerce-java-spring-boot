package com.example.demo.controller;

 import com.example.demo.entity.Users;
 import com.example.demo.repository.UserRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;

 import javax.validation.Valid;

@RestController
public class UsersController {
 @Autowired
 private UserRepository userRepository;

 //Register User
@PostMapping("/Register")
 public Users CreateUser(@Valid @RequestBody Users user){

  return userRepository.save(user);
 }

}
