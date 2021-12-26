package net.javaguides.ncp.controller;
import net.javaguides.ncp.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.javaguides.ncp.dao.*;



import java.io.IOException;


/**
 * Servlet implementation class userServlet
 */
@WebServlet("/todo")
public class todoServlet extends HttpServlet {
	static final String dbURL = "jdbc:mysql://localhost:3306/sys";
    static final String dbUser = "root";
    static final String dbPass = "root";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private todo td = new todo();
	private todoDao tododao = new todoDao();
    public todoServlet() {
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
        List<todo> pdt = new ArrayList<todo>();
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection (dbURL,dbUser,dbPass);
            String sql="";
            
            PreparedStatement prep;
            
            	
            sql="select * from todo WHERE todo_id='"+email+"'";
            prep = connection.prepareStatement(sql); 
                
                 rs=prep.executeQuery();

            
            

            while(rs.next()){ 
                todo prod=new todo();
                  
                  prod.setTd(rs.getString("value"));
                  
                  
                  
                  
                  
                  
                  

                  pdt.add(prod);           
        }
            
            		request.setAttribute("list",pdt);

        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/todo.jsp");    
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/todo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tid = (String) session.getAttribute("email");
		String todo = request.getParameter("todo");
		td.setTd(todo);
		td.setEmailId(tid);
		try {
			tododao.registerEmployee(td);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student_home.jsp");
		dispatcher.forward(request, response);
	}


	}


