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
import javax.servlet.http.HttpSession;

import net.javaguides.ncp.dao.*;
/**
 * Servlet implementation class forget_passwordServlet
 */
@WebServlet("/update_password")
public class update_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private reset_passwordDao forget_passworddao = new reset_passwordDao();
    public update_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/update_password.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");
		String password = request.getParameter("password");
		String reenter = request.getParameter("reenter");
		
		reset_password forget_password = new reset_password();
		//String email= "hridhi.sethi@gmail.com";
		
		forget_password.setEmail(email);
	
		forget_password.setPassword(password);
		forget_password.setReset(reenter);
	
		try {
			Integer x= forget_passworddao.registerEmployee(forget_password);
			
			if (x==0) {
				System.out.println("correct credentials");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/faculty_home.jsp");
				dispatcher.forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='3;URL=reset_password'>");//redirects after 3 seconds
				out.println("<p style='color:red;'>forget_password or password incorrect/empty!</p>");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/forget_password.jsp");
//				dispatcher.forward(request, response);
				System.out.println("Wrong credentials");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
