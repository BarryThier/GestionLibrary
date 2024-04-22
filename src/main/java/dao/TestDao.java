package dao;

import java.util.List;

import metier.entities.Books;
import metier.entities.User;

public class TestDao {

	public static void main(String[] args) {
		
		User user = new User("Barry Thierno Ousmane", "Etudiant", "barrythiernoousmane326@gmail.com", "Ousmane@2002");
		UserDaoImpl metier = new UserDaoImpl();
		metier.save(user);
		System.out.println(user.toString());
		/* System.out.println("Chercher les livres");
			List<Books> books = dao.BooksForMc("%M%");
			for (Books boo : books) {
			System.out.println(boo.toString());
		*/
		}

}
