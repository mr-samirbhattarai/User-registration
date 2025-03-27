package com.workshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.workshop.database.DatabaseConnection;
import com.workshop.model.User;

public class UserDAO {
	// why DAO? to perform CRUD Operations for user entity

	private Connection conn;
	public UserDAO() {
		try {
			this.conn = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean addUser(User user) {
		boolean isRowInserted = false;
		
		String querry = "INSERT INTO user(firstname, lastname, username, gender, email, phone_no, password, birthday, subject) VALUES (?,?,?,?,?,?,?,?,?)";
		
		if(conn != null) {
			
			try {
				PreparedStatement ps = conn.prepareStatement(querry);
				ps.setString(1, user.getFirstname());
				ps.setString(2, user.getLastname());
				ps.setString(3, user.getUsername());
				ps.setString(8, user.getGender());
				ps.setString(6, user.getEmail());
				ps.setString(9, user.getPhno());
				ps.setString(4, user.getPassword());
				ps.setString(7, user.getBirthday());
				ps.setString(5, user.getSubject());
								
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// perform insert operation
			isRowInserted = true;
		}
		return isRowInserted;
		
		
	}
 	
}
