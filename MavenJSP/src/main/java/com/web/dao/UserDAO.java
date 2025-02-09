package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.web.DBConnection;
import com.web.model.User;

public class UserDAO {
	
	public User getUser(int uid) {

		User user = null;
		String sql = "SELECT * FROM tech WHERE uid = ?";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, uid);
			
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					user = new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setTech(rs.getString("tech"));
					System.out.println("✅ Record Found!");
				} else {
					System.out.println("❌ No Record Found!");
				}
			}
			
		} catch (Exception e) {
			System.out.println("❌ Database Error: " + e.getMessage());
            e.printStackTrace(); // Print full error details
		}
		
		return user;
	}
	
	public List<User> getUsers(){
		
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM tech";
		
		try(Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)) {
			
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					User user = new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setTech(rs.getString("tech"));
					userList.add(user);
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("❌ Database Error: " + e.getMessage());
            e.printStackTrace(); // Print full error details
		}
		
		return userList;
	}
	
	public boolean addUser(User user) {

		boolean status = false;
		String sql = "INSERT INTO tech (UNAME, TECH) VALUES (?, ?)";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, user.getUname());
			ps.setString(2, user.getTech());
			
			int rows = ps.executeUpdate();
			status = (rows > 0);
			
			if(status) {
				System.out.println("✅ User added successfully!");
			} else {
				System.out.println("❌ Failed to add user.");
			}
			
		} catch (SQLException e) {
			System.out.println("❌ Database Error: " + e.getMessage());
			e.printStackTrace();
		}
		
		return status;
	}
	
}






