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
    private Long index;

    public List<User> getAllUsers() {
        return USERS.values().stream().collect(Collectors.toList());
    }

    public void createUser(User user) {
        user.setId(index);
        USERS.put(index, user);
        index = index+1;
    }

    public void updateUser(Long id, User user) {
        getUserByParam(id);
        user.setId(id);
        USERS.put(id, user);
    }

    public void deleteUser(Long id) {
        USERS.remove(id);
    }

    public User getUserByParam(Object param) {
        User user = USERS.get(param);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException(String.format("User with parameter %s was not found", param));
        }
        return user;
    }

}
