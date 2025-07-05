package com.project.CarRentalApplication.controller;

import com.project.CarRentalApplication.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserList users;
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void createUser(@RequestBody UserDetails user)
    {
        users.adduser(user);

    }
    @DeleteMapping(path="/delete/{userId}")
    public Boolean deleteUser(@PathVariable String userId)
    {
        return users.deleteUser(userId);
    }

    @GetMapping(path="/get/{userId}")
    public UserDetails getUser(@PathVariable String userId)
    {
        return users.getUser(userId);
    }

    @GetMapping(path="/getAll")
    public List<UserDetails> getUser()
    {
        return users.getAllUsers();
    }

    @PutMapping(path="/update/{userId}")
    public void updateUser(@PathVariable String userId,
                                  @RequestBody UserDetails user)
    {
        users.updateUser(userId, user);
    }

}
