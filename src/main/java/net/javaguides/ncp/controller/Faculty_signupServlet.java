package net.javaguides.ncp.controller;
import net.javaguides.ncp.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.javaguides.ncp.dao.*;

@WebServlet("/Faculty_signup")
public class Faculty_signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private Faculty_signupDao Faculty_signupdao = new Faculty_signupDao();
    public Faculty_signupServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/faculty_signup.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String reenter = request.getParameter("reenter");
		String security = request.getParameter("security");
		Faculty_signup User = new Faculty_signup();
		
		User.setEmail(email);
		User.setName(name);
		User.setPassword(password);
		User.setReenter(reenter);
		User.setSecurity(security);
		
		try {
			Integer x= Faculty_signupdao.registerEmployee(User);
			System.out.println(x);
			if (x==10) {
				System.out.println("wrong credentials- already existing ");
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='3;URL=Faculty_signup'>");
				out.println("<p style='color:red;'>User already exists!</p>");

				System.out.println("Wrong credentials");
				
			}
			else {
				if(x==11) {
					System.out.println("wrong credentials- already existing ");
					PrintWriter out = response.getWriter();
					out.println("<meta http-equiv='refresh' content='3;URL=Faculty_signup'>");
					out.println("<p style='color:red;'>Passwords doesnt match!</p>");

					System.out.println("Wrong credentials");
					
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/faculty_home.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
