package net.javaguides.ncp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.ncp.model.filter_publication;

/**
 * Servlet implementation class filter_publication2Servlet
 */
@WebServlet("/filterpublication2")
public class filter_publication2Servlet extends HttpServlet {
	static final String dbURL = "jdbc:mysql://localhost:3306/sys";
    static final String dbUser = "root";
    static final String dbPass = "root";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filter_publication2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/filter_publication2.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		int option = Integer.parseInt(request.getParameter("option"));
		System.out.println(search);
		System.out.println(option);
		response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter();
        ResultSet rs = null;
        Connection connection = null;   
        List<filter_publication> pdt = new ArrayList<filter_publication>();
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection (dbURL,dbUser,dbPass);
            String sql="";
            System.out.println(option);
            if(option == 1) {
                sql="select * from publication_details where YEAR(acceptance_date)='"+search+"'";

            }
            if(option == 2) {
                 sql="select * from publication_details where faculty_name='"+search+"'";


            } else if(option == 3) {
            	System.out.println("topic entered");
            	  sql="select * from publication_details where title_paper='"+search+"'";
            	
            } else {
            	System.out.println("none entered");
                 sql="select * from publication_details ";

            }
            PreparedStatement prep = connection.prepareStatement(sql); 
            rs=prep.executeQuery();

            while(rs.next()){ 
                filter_publication prod=new filter_publication();
                  prod.setStudent_name(rs.getString("student_name"));
                  prod.setRoll_number(rs.getString("roll_number"));
                  prod.setTitle_paper(rs.getString("title_paper"));
                  prod.setLink_publication(rs.getString("link_publication"));
                  
                  
                  
                  
                  
                  
                  System.out.println(rs.getString("student_name"));

                  pdt.add(prod);           
        }
            
            		request.setAttribute("list",pdt);

        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/filter_publication2.jsp");    
        rd.forward(request,response); 

            prep.close();
        } catch(Exception E) {
            //Any Exceptions will be caught here
            System.out.println("The error is"+E.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                System.out.println("The error is" + ex.getMessage());
            }
        }
		
	}

}
