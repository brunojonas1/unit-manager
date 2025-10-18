package com.company.unitmanager.service;

import com.company.unitmanager.exception.InvalidCredentialsException;
import com.company.unitmanager.exception.InvalidDataException;
import com.company.unitmanager.exception.UserAlreadyExistsException;
import com.company.unitmanager.model.User;
import com.company.unitmanager.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> users = new ArrayList<>();
    private static int nextUserId = 1;

    public static User registerUser(String username, String password) {
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            throw new InvalidDataException("Nome de usuário ou senha inválidos");
        }
        for (User u : users) {
            if(u.getUsername().equalsIgnoreCase(username)) {
                throw new UserAlreadyExistsException("Usuário já existe: " + username);
            }
        }
        User user = new User(username.trim(), password.trim());
        user.setIdUser(nextUserId++);
        users.add(user);

        UserRepository.saveUsers(users);
        return user;
    }

    public static User loginUser(String username, String password) {
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            throw new InvalidDataException("Nome de usuário ou senha inválidos");
        }
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                if (u.getPassword().equalsIgnoreCase(password)) {
                    return u;
                } else {
                    throw new InvalidCredentialsException("Usuário ou senha incorreta");
                }
            }
        }
        throw new InvalidDataException("Usuário não encontrado");
    }



}
