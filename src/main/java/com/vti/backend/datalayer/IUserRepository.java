package com.vti.backend.datalayer;

import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public List<User> getListUsersByProjectId(int projectId) throws SQLException, IOException, ClassNotFoundException;

    public boolean isProjectIdExists(int projectId) throws SQLException, IOException, ClassNotFoundException;

    public User login(String email, String password) throws SQLException, IOException, ClassNotFoundException;

    public int addUser(String fullName, String email) throws SQLException, IOException, ClassNotFoundException;

    public boolean isEmailExists(String email) throws SQLException, IOException, ClassNotFoundException;
}
