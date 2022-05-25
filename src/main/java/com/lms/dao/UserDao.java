package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.entity.User;

public class UserDao extends GenericDao {

	public void addUser(User user) {
		 String query = "INSERT INTO libman.user_details(first_name, last_name, email_id , phone_number ,address, pincode) VALUES (?,?,?,?,?,?)";
	        Connection connection = getConnection();
	        try {
	            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	            statement.setString(1, user.getFirstName());
	            statement.setString(2, user.getLastName());
	            statement.setString(3, user.getEmailId());
	            statement.setString(4, user.getPhoneNumber());
	            statement.setString(5, user.getAddress());
	            statement.setString(6, user.getPinCode());
	            statement.executeUpdate();
	            ResultSet rs = statement.getGeneratedKeys();
	            if(rs.next()) {
	            	user.setUserId(rs.getInt(1));
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
	}
	
	public List<User> getAllUsers() {
		String sql = "select user_id,first_name, last_name, email_id , phone_number ,address, pincode  from libman.user";
        Connection connection = getConnection();
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmailId(rs.getString("email_id"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setAddress(rs.getString("address"));
                user.setPinCode(rs.getString("pincode"));
                users.add(user);
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
        return users;
	}
}
