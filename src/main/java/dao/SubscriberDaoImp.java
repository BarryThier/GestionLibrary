package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import metier.entities.Subscriber;

public class SubscriberDaoImp implements ISubscriberDao{


	@Override
	public Subscriber save(Subscriber subscriber) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO subscriber (Nom,Adresse,Telephone,DateAdh,DateNaissance,CategorieProfessionnelle) VALUES(?,?,?,?,?,?)");
			ps.setString(1, subscriber.getName());
			ps.setString(2, subscriber.getAdresse());
			ps.setString(3, subscriber.getPhone());
			ps.setString(4, subscriber.getDateAdh());
			ps.setString(5, subscriber.getYearBirth());
			ps.setString(6, subscriber.getProfessionalCategory());
			
			ps.executeUpdate();
			
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(NumMatricule) AS MAX_NumMatricule FROM subscriber");
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next()) {
				subscriber.setNumMatricule(rs.getInt("MAX_NumMatricule"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subscriber;
	}

	@Override
	public List<Subscriber> getAllSubscriber() {
		Connection connection = SingletonConnection.getConnection();
		List<Subscriber> subscribers = null;
		try {
			subscribers = new ArrayList<Subscriber>();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM subscriber");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Subscriber subscriber = new Subscriber();
				subscriber.setNumMatricule(rs.getInt("NumMatricule"));
				subscriber.setName(rs.getString("Nom"));
				subscriber.setAdresse(rs.getString("Adresse"));
				subscriber.setPhone(rs.getString("Telephone"));
				subscriber.setDateAdh(rs.getString("DateAdh"));
				subscriber.setYearBirth(rs.getString("DateNaissance"));
				subscriber.setProfessionalCategory(rs.getString("CategorieProfessionnelle"));
				
				subscribers.add(subscriber);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subscribers;
	}

	@Override
	public Subscriber getSubscriber(int id) {
		Connection connection = SingletonConnection.getConnection();
		Subscriber subscriber = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM subscriber WHERE NumMatricule = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				subscriber = new Subscriber();
				subscriber.setNumMatricule(rs.getInt("NumMatricule"));
				subscriber.setName(rs.getString("Nom"));
				subscriber.setAdresse(rs.getString("Adresse"));
				subscriber.setPhone(rs.getString("Telephone"));
				subscriber.setDateAdh(rs.getString("DateAdh"));
				subscriber.setYearBirth(rs.getString("DateNaissance"));
				subscriber.setProfessionalCategory(rs.getString("CategorieProfessionnelle"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subscriber;
	}

	@Override
	public Subscriber updateSubscriber(Subscriber subscriber) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE subscriber SET Nom = ?, Adresse = ?, Telephone = ?, DateAdh = ?, DateNaissance = ?, CategorieProfessionnelle = ? WHERE NumMatricule = ?");
			ps.setString(1, subscriber.getName());
			ps.setString(2, subscriber.getAdresse());
			ps.setString(3, subscriber.getPhone());
			ps.setString(4, subscriber.getDateAdh());
			ps.setString(5, subscriber.getYearBirth());
			ps.setString(6, subscriber.getProfessionalCategory());
			ps.setInt(7, subscriber.getNumMatricule());
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
		return subscriber;
	}

	@Override
	public void deleteSubscriber(int numMatricule) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM subscriber WHERE NumMatricule = ?");
			ps.setInt(1, numMatricule);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

}
