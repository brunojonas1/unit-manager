package com.company.unitmanager.controller;

import com.company.unitmanager.model.User;
import com.company.unitmanager.service.UserService;

public class UserController {

    public static User registerUser(String username, String password) {
        return UserService.registerUser(username, password);
    }

    public static User loginUser(String username, String password) {
        return UserService.loginUser(username, password);
    }

}
