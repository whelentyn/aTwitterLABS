package com.example.project.services;
import com.example.project.models.User;
import com.example.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public void registerUser(Long id, User user) {
        userRepository.createUser(id, user);
    }

    public void updateUser(Long id, User user) {
        userRepository.updateUser(id, user);
    }

    public void patchUser(Long id, Map<String, String> partialUser) {
        User user = userRepository.getUserById(id);
        String updatedUsername = partialUser.get("username");
        String updatedPassword = partialUser.get("password");
        String updatedEmail = partialUser.get("email");
        user.setUsername(updatedUsername);
        user.setPassword(updatedPassword);
        user.setEmail(updatedEmail);
        userRepository.updateUser(id, user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
