package net.javaguides.ncp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.ncp.model.*;

/**
 * Servlet implementation class marks_formServlet
 */
@WebServlet("/marks_formServlet")
public class marks_formServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public marks_formServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/marks_form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello entered marks_servlet");
		// TODO Auto-generated method stub
		
		//  String INSERT_USERS_SQL = "UPDATE publication_details SET grace_marks = ? WHERE roll_number = ? AND title_paper = ? AND student_name = ?";
		  String INSERT_USERS_SQL = "UPDATE publication_details SET grace_marks = ? WHERE title_paper = ?";

		  int result = 0;
		String student_name = request.getParameter("student_name");
		String roll_number = request.getParameter("roll_number");
		String title_paper = request.getParameter("title_paper");
		int grace_marks = Integer.parseInt(request.getParameter("grace-marks"));
		System.out.println("hello"+title_paper);
		System.out.println(grace_marks);
		
		
		
		try {
			
			 Class.forName("com.mysql.jdbc.Driver");
	           
	            Connection connection = DriverManager
	                  .getConnection("jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false","root","root");
	            java.sql.Statement stmt = connection.createStatement();
	            
	       	
	   		PreparedStatement pp = connection.prepareStatement(INSERT_USERS_SQL);
//	    		pp.setString(4,student_name);
//	    		pp.setString(2,roll_number);
	    		pp.setString(2,title_paper);
	    		pp.setInt(1, grace_marks);
	    		
	    		
	    		
	    		
	    	int rs = pp.executeUpdate();
	    	System.out.println(rs);
	    	response.sendRedirect("/NCP_PROJECT/grace_marks");
	          
			
		} catch (ClassNotFoundException   | SQLException sql) {
			// TODO Auto-generated catch block
			System.out.println(sql);
		}
		
	}

}
