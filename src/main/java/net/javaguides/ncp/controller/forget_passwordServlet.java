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
@WebServlet("/forget_password")
public class forget_passwordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private forget_passwordDao forget_passworddao = new forget_passwordDao();
    public forget_passwordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/forget_password.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		//String name = request.getParameter("name");
		String value = request.getParameter("value");
		//Integer no_pub = Integer.parseInt(request.getParameter("no_pub"));
		forget_password forget_password = new forget_password();
		forget_password.setEmail(email);
		//forget_password.setName(name);
		forget_password.setValue(value);
		//forget_password.setNo_pub(no_pub);
		try {
			Integer x= forget_passworddao.registerEmployee(forget_password);
			System.out.println(x);
			if (x==0) {
				System.out.println("correct credentials");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/fp_support.jsp");
				HttpSession session = request.getSession(false);
				//save message in session
				session.setAttribute("email", email);
				response.sendRedirect("fp_support") ;
				//dispatcher.forward(request, response);
				
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='3;URL=forget_password'>");//redirects after 3 seconds
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
