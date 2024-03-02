/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sant;

/**
 *
 * @author santh
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {
public static String isValidUser(String email, String password) {
    try {
        Connection con = DBConnector.getConnection();

        String query = "SELECT * FROM users WHERE email=?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Email is registered, now check the password
            String storedPassword = resultSet.getString("password");
            if (password != null && password.equals(storedPassword)) {
                // Password is correct, return the email (username)
                return resultSet.getString("username");
            } else {
                // Password is incorrect
                return "Incorrect password";
            }
        } else {
            // Email is not registered
            return "Email is not registered";
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBConnector.closeConnection();
    }
    return null; // Return a generic error message
}




    public static String registerUser(String username, String email, String password, String dateOfBirth,
            String gender, String maritalStatus, String phone) {
        try {
            Connection con = DBConnector.getConnection();

            // Check if email already exists
            if (emailExists(email)) {
                return "Email already exists";
            }

            // Check if phone number already exists
            if (phoneExists(phone)) {
                return "Phone number already exists";
            }

            // Insert user details into the database
            String query = "INSERT INTO users (username, email, password, dateOfBirth, gender, maritalStatus, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, dateOfBirth);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, maritalStatus);
            preparedStatement.setString(7, phone);

            int result = preparedStatement.executeUpdate();

            return (result > 0) ? "Registration successful" : "Registration failed";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Registration failed";
        } finally {
            DBConnector.closeConnection();
        }
    }

    private static boolean emailExists(String email) throws SQLException {
        Connection con = DBConnector.getConnection();
        String query = "SELECT * FROM users WHERE email=?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    private static boolean phoneExists(String phone) throws SQLException {
        Connection con = DBConnector.getConnection();
        String query = "SELECT * FROM users WHERE phone=?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, phone);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
