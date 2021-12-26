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
@WebServlet("/fp_support")
public class fp_supportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private fp_supportDao forget_passworddao = new fp_supportDao();
    public fp_supportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/fp_support.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String password = request.getParameter("password");
		String reenter = request.getParameter("reenter");
		String email = (String) session.getAttribute("email");
		fp_support forget_password = new fp_support();
		//String email= "hridhi.sethi@gmail.com";
		
		forget_password.setEmail(email);
	
		forget_password.setPassword(password);
		forget_password.setReenter(reenter);
	
		try {
			Integer x= forget_passworddao.registerEmployee(forget_password);
			
			if (x==0) {
				System.out.println("correct credentials");
				response.sendRedirect("register");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
				//dispatcher.forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='3;URL=fp_support'>");//redirects after 3 seconds
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
