package dao;

import java.util.List;

import metier.entities.Books;

public interface IBooksDao {
	
	public Books save (Books book);
	public List<Books> BooksForMc(String mc);
	public List<Books> getAllBooks();
	public Books getBooks(int id);
	public Books updateBooks(Books book);
	public void deleteBooks(int codeCatalogue);
	
	
	
	
	
}
