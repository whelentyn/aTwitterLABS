package com.example.project.controllers;

import com.example.project.models.User;
import com.example.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{param}")
    public User getUserByParam(@PathVariable Object param) throws Exception {
        return userService.getUserByParam(param);
    }

    @PostMapping
    public void registerUser(@RequestBody User user) throws Exception {
        userService.registerUser(user);
    }

    @PostMapping("/{id}")
    public void patchUser(@PathVariable Long id, @RequestBody Map<String, String> partialUser) {
        userService.patchUser(id, partialUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
