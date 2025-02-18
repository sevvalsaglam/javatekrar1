package com.example.javatekrar1.controller;

import com.example.javatekrar1.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    public UserController() {

        users.add(new User(1, "Ali", "ali@example.com"));
        users.add(new User(2, "Veli", "veli@example.com"));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        users.add(user);
        return "User added!";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        users.removeIf(user -> user.getId() == id);
        return "User deleted!";
    }
}
