package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.entities.User;

import java.io.IOException;
import java.util.List;


import dao.IUser;
import dao.UserDaoImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "UserServlet",urlPatterns = {"/saveUser","/allUsers","/updateUser","/deleteUser","/editUser","/searchUser","/login"})
public class UserServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    private IUser metier;

    @Override
    public void init() throws ServletException {
        metier = new UserDaoImpl();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        
        if("/saveUser".equals(path)) {
            registerUser(request, response);
        }else if ("/allUsers".equals(path)) {
            listAllUser(request, response);
        }else if ("/updateUser".equals(path)) {
            updateUser(request, response);
        }else if ("/deleteUser".equals(path)) {
            deleteUser(request, response);
        }else if ("/editUser".equals(path)) {
            editUser(request, response);
        }else if ("/searchUser".equals(path)) {
            searchUser(request, response);
        }else if ("/login".equals(path)) {
        	login(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = metier.users(); 
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/allUser.jsp");
        dispatcher.forward(request, response);
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String pseudo = request.getParameter("pseudo");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String hashedPassword = hashPassword(password);
        
        if (hashedPassword != null && !hashedPassword.isEmpty()) {
            User newUser = new User(fullName, pseudo, email, hashedPassword);
            metier.save(newUser);
        }
        
        response.sendRedirect(request.getContextPath() + "/allUsers");
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long user_id = Long.parseLong(request.getParameter("user_id"));
        User user = metier.getUser(user_id);
        
        request.setAttribute("searchedUser", user);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/searchResultsUser.jsp");
        dispatcher.forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long user_id = Long.parseLong(request.getParameter("user_id"));
        User user = metier.getUser(user_id);
        
        request.setAttribute("user", user);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/updateUser.jsp");
        dispatcher.forward(request, response);
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long user_id = Long.parseLong(request.getParameter("user_id"));
        String fullName = request.getParameter("fullName");
        String pseudo = request.getParameter("pseudo");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String hashedPassword = hashPassword(password);
        
        User updateUser = new User(fullName, pseudo, email, hashedPassword);
        updateUser.setUser_id(user_id);
        
        metier.updateUser(updateUser);
        
        response.sendRedirect(request.getContextPath() + "/allUsers");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long user_id = Long.parseLong(request.getParameter("user_id"));
        metier.deleteUser(user_id);
        response.sendRedirect(request.getContextPath() + "/allUsers");
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo = request.getParameter("pseudo");
        String password = request.getParameter("password");
        String hashedPassword = hashPassword(password);
        
        boolean isAuthenticate = metier.authenticate(pseudo, hashedPassword);
        
        if (isAuthenticate) {
        	HttpSession session = request.getSession();
        	session.setAttribute("Pseudo", pseudo);
        	response.sendRedirect(request.getContextPath() + "/allUsers");
        }else if (!isAuthenticate) {
        	response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        
    }
}
