package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.User;

public class UserDaoImpl implements IUser {

	@Override
	public User save(User user) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO user(Nom_Complet,Pseudo,Email,MotDePass) VALUES (?,?,?,?)");
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getPseudo());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			
			int test = ps.executeUpdate();
			if(test > 0) System.out.println("Enrégistrement éffectué avec succès");
			else System.out.println("Aucun utilisateur n'a été enrégistré.");
			
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(User_id) AS MaxUser_id FROM user");
			
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next()) {
				user.setUser_id(rs.getInt("MaxUser_id"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> users() {
		Connection connection = SingletonConnection.getConnection();
		List<User> users = null;
		User user = null;
		try {
			users = new ArrayList<User>();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM  user");
			ResultSet rs  = ps.executeQuery();
			
			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt("User_id"));
				user.setFullName(rs.getString("Nom_Complet"));
				user.setPseudo(rs.getString("Pseudo"));
				user.setEmail(rs.getString("Email"));
				user.setPassword(rs.getString("MotDePass"));
				users.add(user);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUser(long user_id) {
		Connection connection = SingletonConnection.getConnection();
		User user = new User();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE User_id = ?");
			ps.setLong(1, user_id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				user.setUser_id(rs.getLong("User_id"));
				user.setFullName(rs.getString("Nom_Complet"));
				user.setPseudo(rs.getString("Pseudo"));
				user.setEmail(rs.getString("Email"));
				user.setPassword(rs.getString("MotDePass"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE user SET Nom_Complet = ?, Pseudo = ?, Email = ?, MotDePass = ? WHERE User_id = ?");
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getPseudo());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setLong(5, user.getUser_id());
			ps.executeUpdate();
			
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				  System.out.println("L'enregistrement a été mis à jour avec succès."); 
				  } else{ 
					  System.out.println("Aucun enregistrement mis à jour.");
				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void deleteUser(long user_id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE User_id = ?");
			ps.setLong(1, user_id);
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean authenticate(String pseudo, String password) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE Pseudo = ? AND MotDePass = ?");
			ps.setString(1, pseudo);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
		
			
			if(rs.next()) {
				String userPassword = rs.getString("MotDePass");
				
				if(password.equals(userPassword) == true) {
					return true;
				}else {
					return false;
				}
			}
		
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
