package com.example._0.Controllers;

import com.example._0.Models.User;
import com.example._0.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @Autowired
    UserRepository userRepository;

    @PostMapping("/addUser")
    public void AddUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
