package com.vti.backend.datalayer;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
    private JDBCUtils jdbcUtils;
    private Connection connection;

    public UserRepository() {
        jdbcUtils = new JDBCUtils();
    }

    @Override
    public List<User> getListUsersByProjectId(int projectId) throws SQLException, IOException, ClassNotFoundException {
        List<User> listUser = new ArrayList<>();

        try{
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "SELECT id, full_name, email, `role` FROM User WHERE project_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setInt(1, projectId);

            //excecute query
            ResultSet resultSet = preparedStatement.executeQuery();

            //handling result set
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                Role role = Role.valueOf(resultSet.getString("role"));
                listUser.add(new User(id, fullName, email, role));
            }
            return listUser;
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public boolean isProjectIdExists(int projectId) throws SQLException, IOException, ClassNotFoundException {
        try{
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "SELECT * FROM User WHERE project_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setInt(1, projectId);

            //excecute execute
            ResultSet resultSet = preparedStatement.executeQuery();

            //handling result set
            if (resultSet.next()){
                return true;
            } else{
                return false;
            }
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public User login(String email, String password) throws SQLException, IOException, ClassNotFoundException {
        try {
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "SELECT id, full_name, `role` FROM User WHERE (email = ? AND BINARY password = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            //excecute execute
            ResultSet resultSet = preparedStatement.executeQuery();

            //handling result set
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String role = resultSet.getString("role");

                if (role.equals("Manager")) {
                    User admin = new Manager(id, fullName, email, Role.Manager);
                    return admin;
                } else {
                    User employee = new Employee(id, fullName, email, Role.Employee);
                    return employee;
                }
            } else{
                return null;
            }
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public int addUser(String fullName, String email) throws SQLException, IOException, ClassNotFoundException {
        try {
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "INSERT INTO User(full_name, email, password, `role`) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, "123456");
            preparedStatement.setString(4, "Employee");

            //excecute update
            int effectedRecordAmount = preparedStatement.executeUpdate();

            //handling result
            return effectedRecordAmount;
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public boolean isEmailExists(String email) throws SQLException, IOException, ClassNotFoundException {
        try{
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "SELECT * FROM User WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setString(1, email);

            //excecute execute
            ResultSet resultSet = preparedStatement.executeQuery();

            //handling result set
            if (resultSet.next()){
                return true;
            } else{
                return false;
            }
        } finally {
            jdbcUtils.disconnect();
        }
    }
}
