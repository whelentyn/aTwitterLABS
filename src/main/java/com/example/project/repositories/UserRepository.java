package com.example.project.repositories;

import com.example.project.exceptions.UserNotFoundException;
import com.example.project.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private Map<Long, User> USERS = new HashMap<>();

    public List<User> getAllUsers() {
        return USERS.values().stream().collect(Collectors.toList());
    }

    public void createUser(Long id, User user) {
        user.setId(id);
        USERS.put(id, user);
    }

    public void updateUser(Long id, User user) {
        getUserById(id);
        user.setId(id);
        USERS.put(id, user);
    }

    public void deleteUser(Long id) {
        USERS.remove(id);
    }

    public User getUserById(Long id) {
        User user = USERS.get(id);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException(String.format("User with id %s was not found", id));
        }
        return user;
    }

}
