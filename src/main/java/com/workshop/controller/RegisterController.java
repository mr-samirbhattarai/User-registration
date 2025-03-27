package com.workshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.workshop.DAO.UserDAO;
import com.workshop.model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterController" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		
		boolean isUserRegistered = false;
		
		response.setContentType("text/html");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");

		
		String username = request.getParameter("username");
		
//		if (username.length() < 6) {
//			response.sendRedirect(request.getContextPath()+"/Pages/register.jsp?error=username");
//			return;
//		}
//		
//		
//		if (username.matches(".*[^a-zA-Z0-9].*")) {
//			response.sendRedirect(request.getContextPath()+"/Pages/register.jsp?error=specialUsername");
//			return;
//		}
		
		String birthdayStr = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Define date format
		Date birthday = null;
//		try {
//			birthday = sdf.parse(birthdayStr);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Date today = new Date();
//		
//		if (birthday.after(today)) {
//			response.sendRedirect(request.getContextPath() + "/Pages/register.jsp?error=birthday");
//			return;
//		}
		
		
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String phno = request.getParameter("phno");
//	
//		if (!phno.matches("\\+[0-9]{13}$")) {
//			response.sendRedirect(request.getContextPath()+"/Pages/register.jsp?error=phno");
//			return;
//		}
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retype-password");
//		
//		if (!password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,}$")) {
//			response.sendRedirect(request.getContextPath()+"/Pages/register.jsp?error=password");
//			return;
//		}	
//		
//		if (!retypePassword.equals(password)) {
//			response.sendRedirect(request.getContextPath()+"/Pages/register.jsp?error=retypePassword");
//			return;
//		}
//		
//		
		User user = new User(firstname, lastname, username, password, subject, email, birthdayStr, gender, phno);
		
		try {
		UserDAO userDAO = new UserDAO();
		isUserRegistered = userDAO.addUser(user);
		
			if (isUserRegistered) {
				out.println("User Registered Successfully");
			} else {
				out.println("User Registration Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		
		out.print("Firstname: " + firstname);
		out.print("Lastname: " + lastname);
		out.println("Username: " + username);
		out.println("Birthday: " + birthdayStr);
		out.println("Gender: " + gender);
		out.println("Email: " + email);
		out.println("Phone Number: " + phno);
		out.println("Subject: " + subject);
		out.println("Password: " + password);
		out.println("RetypePassword: " + retypePassword);
	}

}

