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
 * Servlet implementation class userServlet
 */
@WebServlet("/student_login")
public class student_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private student_loginDao student_logindao = new student_loginDao();
    public student_loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student_login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		//String name = request.getParameter("name");
		String password = request.getParameter("password");
		//Integer no_pub = Integer.parseInt(request.getParameter("no_pub"));
		student_login User = new student_login();
		User.setEmail(email);
		//User.setName(name);
		User.setPassword(password);
		//User.setNo_pub(no_pub);
		try {
			Integer x= student_logindao.registerEmployee(User);
			System.out.println(x);
			if (x==0) {
				System.out.println("correct credentials");
				session.setAttribute("email", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student_home.jsp");
				dispatcher.forward(request, response);
				
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='3;URL=register'>");//redirects after 3 seconds
				out.println("<p style='color:red;'>User or password incorrect/empty!</p>");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
//				dispatcher.forward(request, response);
				System.out.println("Wrong credentials");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
