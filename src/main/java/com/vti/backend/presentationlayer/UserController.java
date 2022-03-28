package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    private IUserService userService;

    public UserController() {
        userService = new UserService();
    }

    public List<User> getListUsersByProjectId(int projectId) throws SQLException, IOException, ClassNotFoundException {
        return userService.getListUsersByProjectId(projectId);
    }

    public boolean isProjectIdExists(int projectId) throws SQLException, IOException, ClassNotFoundException {
        return userService.isProjectIdExists(projectId);
    }

    public User login(String email, String password) throws SQLException, IOException, ClassNotFoundException {
        return userService.login(email, password);
    }

    public int addUser(String fullName, String email) throws SQLException, IOException, ClassNotFoundException {
        return userService.addUser(fullName, email);
    }

    public boolean isEmailExists(String email) throws SQLException, IOException, ClassNotFoundException {
        return userService.isEmailExists(email);
    }
}
