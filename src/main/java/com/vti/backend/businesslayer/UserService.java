package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    private IUserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    @Override
    public List<User> getListUsersByProjectId(int projectId) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.getListUsersByProjectId(projectId);
    }

    @Override
    public boolean isProjectIdExists(int projectId) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.isProjectIdExists(projectId);
    }

    @Override
    public User login(String email, String password) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.login(email, password);
    }

    @Override
    public int addUser(String fullName, String email) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.addUser(fullName, email);
    }

    @Override
    public boolean isEmailExists(String email) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.isEmailExists(email);
    }
}
