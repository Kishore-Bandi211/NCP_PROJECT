package net.javaguides.ncp.controller;
import net.javaguides.ncp.model.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



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
@WebServlet("/grace_marks")
public class grace_marksServlet extends HttpServlet {
	static final String dbURL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
    static final String dbUser = "root";
    static final String dbPass = "root";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private grace_marksDao grace_marksdao = new grace_marksDao();
	private publication_update pu = new publication_update();

    public grace_marksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("grace marks");
		 String sPath = request.getParameter("key");

//		String sPath = request.getServletPath();
		System.out.println(sPath);
		if(sPath == null) {
			try {
				
	             listAllStudents(request, response); //home page = .../week04/StudentServlet
	         } catch (ServletException | IOException | SQLException e) {
	             e.printStackTrace();
	         } 
		} else {
			editStudent(request, response);
		}
//		switch(sPath) {
//		case "edit":
//			
//			editStudent(request, response);
//			break;
//		default:
//			
//			
//			try {
//				
//             listAllStudents(request, response); //home page = .../week04/StudentServlet
//         } catch (ServletException | IOException | SQLException e) {
//             e.printStackTrace();
//         } 
//			
//			break;
//		}
		}
	
	 private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 String id = request.getParameter("id");
	        upload_paper currentStudent = pu.selectStudent(id);
	        System.out.println(currentStudent);
//	        RequestDispatcher dispatch = request.getRequestDispatcher("marks_formServlet");
//	        request.setAttribute("student", currentStudent); 
//	        dispatch.forward(request, response);
		
	        request.getSession().setAttribute("student", currentStudent);
	        response.sendRedirect("/NCP_PROJECT/marks_formServlet");
	}

	private void listAllStudents(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException, SQLException {
		 

			HttpSession session = request.getSession();

			
			String email = (String) session.getAttribute("email");
			
			response.setContentType("text/html;charset=UTF-8"); 
	        PrintWriter out = response.getWriter();
	        ResultSet rs = null;
	        Connection connection = null;   
	        List<grace_marks_list> pdt = new ArrayList<grace_marks_list>();
	        try{
	            
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection (dbURL,dbUser,dbPass);
	            String sql="";
	            
	            PreparedStatement prep;
	            
	            	
	                 sql="select * from publication_details WHERE faculty_name='"+email+"'";
	                  prep = connection.prepareStatement(sql); 
	                
	                 rs=prep.executeQuery();

	            
	            

	            while(rs.next()){ 
	                grace_marks_list prod=new grace_marks_list();
	                  prod.setStudent_name(rs.getString("student_name"));
	                  prod.setRoll_number(rs.getString("roll_number"));
	                  prod.setTitle_paper(rs.getString("title_paper"));
	                  prod.setLink_publication(rs.getString("link_publication"));
	                  prod.setGrace_marks(rs.getInt("grace_marks"));                  
	                  
	                  
	                  
	                  
	                  
	                  
	                  System.out.println(rs.getInt("grace_marks"));

	                  pdt.add(prod);           
	        }
	            
	            		request.setAttribute("list",pdt);

	        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/grace_marks.jsp");    
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
//			response.getWriter().append("Served at: ").append(request.getContextPath());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/grace_marks.jsp");
//			dispatcher.forward(request, response);
	        
	    }
	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
