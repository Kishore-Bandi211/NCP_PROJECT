package net.javaguides.ncp.controller;
import net.javaguides.ncp.model.*;
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
import javax.servlet.http.HttpSession;

import net.javaguides.ncp.dao.*;
/**
 * Servlet implementation class userServlet
 */
@WebServlet("/form")
public class formServlet extends HttpServlet {
	static final String dbURL = "jdbc:mysql://localhost:3306/sys";
    static final String dbUser = "root";
    static final String dbPass = "root";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//	private filter_publicationDao filter_publicationdao = new filter_publicationDao();
    public formServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");

		response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter();
        ResultSet rs = null;
        Connection connection = null;   
        List<prev_publication> pdt = new ArrayList<prev_publication>();
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection (dbURL,dbUser,dbPass);
            String sql="";
            
            PreparedStatement prep;
            
            	System.out.println("none entered");
                 sql="select * from publication_details WHERE faculty_name='"+email+"'";
                  prep = connection.prepareStatement(sql); 
                
                 rs=prep.executeQuery();

            
            

            while(rs.next()){ 
                prev_publication prod=new prev_publication();
                  prod.setStudent_name(rs.getString("student_name"));
                  prod.setRoll_number(rs.getString("roll_number"));
                  prod.setTitle_paper(rs.getString("title_paper"));
                  prod.setLink_publication(rs.getString("link_publication"));
                  prod.setGrace_marks(Integer.parseInt(rs.getString("grace_marks")));
                  
                  
                  
                  
                  
                  
                  System.out.println(rs.getString("student_name"));

                  pdt.add(prod);           
        }
            
            		request.setAttribute("list",pdt);

        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/forms.jsp");    
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
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/forms.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
