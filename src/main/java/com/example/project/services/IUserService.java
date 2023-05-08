package com.example.project.services;

import com.example.project.models.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    List<User> getAllUsers();

    User getUserByParam (Object param) throws Exception;

    void registerUser(User user) throws Exception;

    void updateUser(Long id, User user);

    void patchUser(Long id, Map<String, String> partialUser);

    void deleteUser(Long id);


}
