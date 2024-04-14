package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Books;

public class BooksDaoImpl implements IBooksDao{

	@Override
	public Books save(Books book) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO books(Titre,Auteur,Editeur,Theme,DateAcq,CodeUsure) VALUES (?,?,?,?,?,?)");
			ps.setString(1, book.getTitre());
			ps.setString(2, book.getAuteur());
			ps.setString(3, book.getEditeur());
			ps.setString(4, book.getTheme());
			ps.setString(5, book.getDateAcq());
			ps.setString(6, book.getCodeUsure());
			
			ps.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(CodeCatalogue) AS MAX_CodeCatalogue FROM books ");
			
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				book.setCodeCatalogue(rs.getInt("MAX_CodeCatalogue"));
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Books> BooksForMc(String mc) {
		List<Books> books = new ArrayList<Books>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM books WHERE Titre LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Books book = new Books();
				book.setCodeCatalogue(rs.getInt("CodeCatalogue"));
				book.setTitre(rs.getString("Titre"));
				book.setAuteur(rs.getString("Auteur"));
				book.setEditeur(rs.getString("Editeur"));
				book.setTheme(rs.getString("Theme"));
				book.setDateAcq(rs.getString("DateAcq"));
				book.setCodeUsure(rs.getString("CodeUsure"));
				books.add(book);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	
	@Override
	public Books updateBooks(Books book) {
	    Connection connection = SingletonConnection.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("UPDATE books SET Titre = ?, Auteur = ?, Editeur = ?, Theme = ?, DateAcq = ?, CodeUsure = ? WHERE CodeCatalogue = ?");
	        ps.setString(1, book.getTitre());
	        ps.setString(2, book.getAuteur());
	        ps.setString(3, book.getEditeur());
	        ps.setString(4, book.getTheme());
	        ps.setString(5, book.getDateAcq());
	        ps.setString(6, book.getCodeUsure());
	        ps.setInt(7, book.getCodeCatalogue()); 
	        int rowsAffected = ps.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("L'enregistrement a été mis à jour avec succès.");
	        } else {
	            System.out.println("Aucun enregistrement mis à jour.");
	        }

	        ps.close();
	    } catch (SQLException e) {
	        System.err.println("Erreur lors de la mise à jour de l'enregistrement : " + e.getMessage());
	        e.printStackTrace();
	    }
	    return book;
	}

	
	@Override
	public Books getBooks(int id) {
		Connection connection = SingletonConnection.getConnection();
		Books book = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM books WHERE CodeCatalogue = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new Books();
				book.setCodeCatalogue(rs.getInt("CodeCatalogue"));
				book.setTitre(rs.getString("Titre"));
				book.setAuteur(rs.getString("Auteur"));
				book.setEditeur(rs.getString("Editeur"));
				book.setTheme(rs.getString("Theme"));
				book.setDateAcq(rs.getString("DateAcq"));
				book.setCodeUsure(rs.getString("CodeUsure"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void deleteBooks(int codeCatalogue) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE CodeCatalogue = ?");
			ps.setInt(1, codeCatalogue);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Books> getAllBooks() {
		Connection connection = SingletonConnection.getConnection();
		List<Books> books = null ;
		try {
			books = new ArrayList<Books>();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM books");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Books book = new Books();
				book.setCodeCatalogue(rs.getInt("CodeCatalogue"));
				book.setAuteur(rs.getString("Auteur"));
				book.setTitre(rs.getString("Titre"));
				book.setEditeur(rs.getString("Editeur"));
				book.setTheme(rs.getString("Theme"));
				book.setDateAcq(rs.getString("DateAcq"));
				book.setCodeUsure(rs.getString("CodeUsure"));

				books.add(book);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	

}
