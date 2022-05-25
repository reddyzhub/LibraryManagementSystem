package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lms.entity.LoginDetails;

public class LoginDetailsDao extends GenericDao {

	public void addLogin(LoginDetails loginDetails) {
		 String query = "INSERT INTO libman.login(user_id,login_id, password, is_admin) VALUES (?,?,?,?)";
	        Connection connection = getConnection();
	        try {
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, loginDetails.getUserId());
	            statement.setString(2, loginDetails.getLoginId());
	            statement.setString(3, loginDetails.getPassword());
	            statement.setBoolean(4, loginDetails.isAdmin());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	
	public LoginDetails getLoginDetails(String loginId) {
		String sql = "select user_id,login_id, password, is_admin from libman.login where login_id=? ";
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, loginId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                LoginDetails user = new LoginDetails();
                user.setUserId(rs.getInt("user_id"));
                user.setLoginId(rs.getString("login_id"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("is_admin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}
}
