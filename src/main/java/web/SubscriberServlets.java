package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import metier.entities.Subscriber;

import java.io.IOException;
import java.util.List;


import dao.ISubscriberDao;
import dao.SubscriberDaoImp;

@WebServlet(name = "SubscriberServlets", urlPatterns = {"/saveSubscriber","/allSubscriber","/updateSubscriber","/deleteSubscriber","/editSubscriber","/searchSubscriber"})

public class SubscriberServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ISubscriberDao metier;
	@Override
	public void init() throws ServletException {
		metier = new SubscriberDaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		if("/saveSubscriber".equals(path)) {
			registerSubscriber(request, response);
		}else if ("/allSubscriber".equals(path)) {
			listAllSubscriber(request, response);
		}else if ("/updateSubscriber".equals(path)) {
			updateSubscriber(request, response);
		}else if ("/deleteSubscriber".equals(path)) {
			deleteSubscriber(request, response);
		}else if ("/editSubscriber".equals(path)) {
			editSubscriber(request, response);
		}else if ("/searchSubscriber".equals(path)) {
			searchSubscriber(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	  private void listAllSubscriber(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  
	  List<Subscriber> subscribers = metier.getAllSubscriber(); 

	  request.setAttribute("subscribers", subscribers);
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/allSubscriber.jsp");
	  dispatcher.forward(request, response); }
	 
	private void registerSubscriber(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String name = request.getParameter("name");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String dateAdh = request.getParameter("dateAdh");
        String dateNaissance = request.getParameter("dateNaissance");
        String professionalCategory = request.getParameter("professionalCategory");

        
        Subscriber newSubscriber = new Subscriber(name, adresse, telephone, dateAdh,dateNaissance,professionalCategory);
        metier.save(newSubscriber);
        request.setAttribute("subscriber", newSubscriber);
        System.out.println(newSubscriber.toString());

        //RequestDispatcher dispatcher = request.getRequestDispatcher("/confirm.jsp");
        //dispatcher.forward(request, response);
        response.sendRedirect(request.getContextPath() + "/allSubscriber");
    }
	  private void searchSubscriber(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	      
	        int numMatricule = Integer.parseInt(request.getParameter("numMatricule"));

	      
	        Subscriber  subscriber = metier.getSubscriber(numMatricule);

	      
	        request.setAttribute("searchedSubscriber", subscriber);

	       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/searchResults.jsp");
	        dispatcher.forward(request, response);
	    }
	 private void editSubscriber(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int numMatricule = Integer.parseInt(request.getParameter("numMatricule"));
	        Subscriber subscriber = metier.getSubscriber(numMatricule);
	        request.setAttribute("subscriber", subscriber);
	        

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/updateSubscriber.jsp");
	        dispatcher.forward(request, response);
	    }
	private void updateSubscriber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int numMatricule = Integer.parseInt(request.getParameter("numMatricule"));
	    String name = request.getParameter("name");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String dateAdh = request.getParameter("dateAdh");
        String dateNaissance = request.getParameter("dateNaissance");
        String professionalCategory = request.getParameter("professionalCategory");

	    
	    Subscriber  updateSubscriber = new Subscriber(name, adresse, telephone, dateAdh, dateNaissance, professionalCategory);
	    updateSubscriber.setNumMatricule(numMatricule);
	    
	    
	    metier.updateSubscriber(updateSubscriber);
	    
	   
	    request.setAttribute("Subscriber", updateSubscriber);

	
	    response.sendRedirect(request.getContextPath() + "/allSubscriber");
	}

	  private void deleteSubscriber(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int numMatricule = Integer.parseInt(request.getParameter("numMatricule"));
	        metier.deleteSubscriber(numMatricule);

	        response.sendRedirect(request.getContextPath() + "/allSubscriber");
	    }

}
