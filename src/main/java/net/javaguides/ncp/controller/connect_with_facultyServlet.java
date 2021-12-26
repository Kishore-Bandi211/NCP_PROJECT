package net.javaguides.ncp.controller;
import net.javaguides.ncp.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.javaguides.ncp.dao.*;
/**
 * Servlet implementation class connect_with_facultyServlet
 */
@WebServlet("/connect")
public class connect_with_facultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private connect_with_facultyDao connect_with_facultydao = new connect_with_facultyDao();
    public connect_with_facultyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/connect_with_faculty.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("search");
		System.out.println(email);
		connect_with_faculty connect_with_faculty = new connect_with_faculty();
		connect_with_faculty.setTop(email);
//		try {
//			connect_with_facultydao.registerEmployee(connect_with_faculty);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		PrintWriter out = response.getWriter();
		String id= request.getParameter("search");
		out.println("<style>\n"
				+ "			html { \n"
				+ "    			background: url(images/ranger-4df6c1b6.png) no-repeat center center fixed; \n"
				+ "    			-webkit-background-size: cover;\n"
				+ "    			-moz-background-size: cover;\n"
				+ "    			-o-background-size: cover;\n"
				+ "    			background-size: cover;\n"
				+ "  			}</style>");
		out.println("<table border=1 width=50% height=50%><tr><th>Name of faculty</th><th>Email</th></tr>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root", "root");
			java.sql.Statement st = con.createStatement();
			String sql = ("SELECT * FROM specialization_faculty WHERE topic = ?");
    		PreparedStatement pp = con.prepareStatement(sql);
    		pp.setString(1,id);
			ResultSet rs = pp.executeQuery();
			while(rs.next()) {
  	    	  Integer in = rs.getInt("id");
  	    	  System.out.println(in);
  	    	  String sql2= ("Select * from faculty Where faculty_id=?");
  	    	  PreparedStatement pp2 = con.prepareStatement(sql2);
        		pp2.setInt(1,in);
        		ResultSet rs2 = pp2.executeQuery();
        		rs2.first();
        		//System.out.print("name: "+rs2.getString("email"));
        		String in2 = rs2.getString("email");
        		String sql3= ("select * from user where email_id= ?");
        		PreparedStatement pp3 = con.prepareStatement(sql3);
        		pp3.setString(1,in2);
        		ResultSet rs3 = pp3.executeQuery();
        		System.out.println(rs3.first());
        		out.println("<tr><td>");
        		out.println(rs3.getString("name"));
        		out.println("</td>");
        		out.println("<td>");
        		out.println(rs3.getString("email_id"));
        		out.println("</td>");
        		out.println("</tr>");
        		
        		 //System.out.println(rs3.first());
  	         //System.out.println("name: "+rs3.getString("name"));
  	         //System.out.println("");
  	      }
out.println("</table>");
		}
		catch(Exception p){
			System.out.println(p);
		}
	}

}
