package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Books;

import java.io.IOException;
import java.util.List;

import dao.BooksDaoImpl;
import dao.IBooksDao;

@WebServlet(name = "cs", urlPatterns = {"/Books","/saveBooks","/allBook","/updateBook","/deleteBook","/editBook"})

public class ControllerServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IBooksDao metier;
	@Override
	public void init() throws ServletException {
		metier = new BooksDaoImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		if("/Books".equals(path)) {
			listBooksForKeywords(request, response);
		}else if("/saveBooks".equals(path)) {
			registerBooks(request, response);
		}else if ("/allBooks".equals(path)) {
			//listAllBooks(request,response);
		}else if ("/updateBook".equals(path)) {
			updateBooks(request, response);
		}else if ("/deleteBook".equals(path)) {
			deleteBook(request, response);
		}else if ("/allBook".equals(path)) {
			listAllBooks(request, response);
		}else if ("/editBook".equals(path)) {
			editBook(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	  private void listAllBooks(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  
	  List<Books> books = metier.getAllBooks(); 

	  request.setAttribute("books", books);
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/allBook.jsp");
	  dispatcher.forward(request, response); }
	 
	private void listBooksForKeywords(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 	
		 	String keywords = request.getParameter("keywords");
		 	BookModel model = new BookModel();
		 	model.setKeywords(keywords);
	        List<Books> books = metier.BooksForMc("%"+keywords+"%");
	        model.setBooks(books);
	        request.setAttribute("model", model);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/books.jsp");
	        dispatcher.forward(request, response);
	    }
	private void registerBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String editeur = request.getParameter("editeur");
        String theme = request.getParameter("theme");
        String dateAcq = request.getParameter("dateAcq");
        String CodeUsure = request.getParameter("CodeUsure");

        
        Books newBook = new Books(titre, auteur, editeur, theme,dateAcq,CodeUsure);
        metier.save(newBook);
        request.setAttribute("book", newBook);

        //RequestDispatcher dispatcher = request.getRequestDispatcher("/confirm.jsp");
        //dispatcher.forward(request, response);
        response.sendRedirect(request.getContextPath() + "/allBook");
    }
	 private void editBook(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int codeCatalogue = Integer.parseInt(request.getParameter("codeCatalogue"));
	        Books book = metier.getBooks(codeCatalogue);
	        request.setAttribute("book", book);
	        

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/updateBook.jsp");
	        dispatcher.forward(request, response);
	    }
	private void updateBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int codeCatalogue = Integer.parseInt(request.getParameter("codeCatalogue"));
	    String titre = request.getParameter("titre");
	    String auteur = request.getParameter("auteur");
	    String editeur = request.getParameter("editeur");
	    String theme = request.getParameter("theme");
	    String dateAcq = request.getParameter("dateAcq");
	    String codeUsure = request.getParameter("codeUsure");

	    
	    Books updateBook = new Books(titre, auteur, editeur, theme, dateAcq, codeUsure);
	    updateBook.setCodeCatalogue(codeCatalogue);
	    
	    
	    metier.updateBooks(updateBook);
	    
	   
	    request.setAttribute("book", updateBook);

	
	    response.sendRedirect(request.getContextPath() + "/allBook");
	}

	  private void deleteBook(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int codeCatalogue = Integer.parseInt(request.getParameter("codeCatalogue"));
	        metier.deleteBooks(codeCatalogue);

	        response.sendRedirect(request.getContextPath() + "/allBook");
	    }

}
