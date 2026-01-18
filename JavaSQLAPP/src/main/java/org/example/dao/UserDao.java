package org.example.dao;

import org.example.config.DBConnection;
import org.example.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public UserModel findByUserName (String userName) {
        String sql = "SELECT * FROM users WHERE username = ?";
        UserModel user = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getString("status"));
                user.setCreatedAT(rs.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public boolean save(UserModel user)  {
        boolean success=true;
        String sql = "INSERT INTO users(userName, email, password, status) VALUES (?,?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getStatus());

            int rows = ps.executeUpdate();
            success =  rows > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return success;

    }
}
