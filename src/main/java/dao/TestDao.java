package dao;

import java.util.List;

import metier.entities.Books;

public class TestDao {

	public static void main(String[] args) {
		BooksDaoImpl dao = new BooksDaoImpl();
		Books book = new Books("Une saison au congo", "ai", "fezsd", "dfxdsx", "2012/12/20", "dsfx");
		dao.save(book);
		System.out.println("Modification");
		dao.updateBooks(book);
		System.out.println(book.toString());
		System.out.println(dao.getAllBooks());
		/* System.out.println("Chercher les livres");
			List<Books> books = dao.BooksForMc("%M%");
			for (Books boo : books) {
			System.out.println(boo.toString());
		*/
		}

}
