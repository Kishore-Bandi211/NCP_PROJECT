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
/**
 * Servlet implementation class userServlet
 */
@WebServlet("/student_signup")
public class student_signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private student_signupDao student_signupdao = new student_signupDao();
    public student_signupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student_signup.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String reenter = request.getParameter("reenter");
		String security = request.getParameter("security");
		String rollnum = request.getParameter("rollnumber");
		student_signup User = new student_signup();
		User.setRollnum(rollnum);
		User.setEmail(email);
		User.setName(name);
		User.setPassword(password);
		User.setReenter(reenter);
		User.setSecurity(security);
		
		try {
			Integer x= student_signupdao.registerEmployee(User);
			System.out.println(x);
			if (x==10) {
				System.out.println("wrong credentials- already existing ");
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='3;URL=student_signup'>");//redirects after 3 seconds
				out.println("<p style='color:red;'>User already exists!</p>");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
//				dispatcher.forward(request, response);
				System.out.println("Wrong credentials");
				
			}
			else {
				if(x==11) {
					System.out.println("wrong credentials- already existing ");
					PrintWriter out = response.getWriter();
					out.println("<meta http-equiv='refresh' content='3;URL=student_signup'>");//redirects after 3 seconds
					out.println("<p style='color:red;'>Passwords doesnt match!</p>");
//					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
//					dispatcher.forward(request, response);
					System.out.println("Wrong credentials");
					
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student_home.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
