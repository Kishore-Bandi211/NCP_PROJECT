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
 * Servlet implementation class userServlet
 */
@WebServlet("/faculty_profile")
public class faculty_profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private faculty_profileDao faculty_profiledao = new faculty_profileDao();
    public faculty_profileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root", "root");
			java.sql.Statement st = con.createStatement();
			String sql = ("SELECT  * FROM user;");
    		PreparedStatement pp = con.prepareStatement(sql);
    		ResultSet rs = pp.executeQuery();
    		System.out.println(rs.first());
    		
    		
		}
		catch (Exception p) {
			System.out.println(p);
		}
		out.println("<head>\n"
				+ "    	<meta charset=\"UTF-8\" />\n"
				+ "    	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"> \n"
				+ "    	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n"
				+ "    	<title>Faculty details</title>\n"
				+ "    	<meta name=\"author\" content=\"Codeconvey\" />\n"
				+ "    	<link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap\" rel=\"stylesheet\"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>\n"
				+ "		<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css'>\n"
				+ "	    <style>\n"
				+ "	    	body {\n"
				+ "    			background: #67B26F;\n"
				+ "    			background: -webkit-linear-gradient(to right, #4ca2cd, #67B26F); \n"
				+ "    			background: linear-gradient(to right, #4ca2cd, #67B26F);\n"
				+ "    			padding: 0;\n"
				+ "    			margin: 0;\n"
				+ "    			font-family: 'Lato', sans-serif;\n"
				+ "    			color: #000;\n"
				+ "			}\n"
				+ "			.student-profile .card {\n"
				+ "    			border-radius: 10px;\n"
				+ "			}\n"
				+ "			.student-profile .card .card-header .profile_img {\n"
				+ "    			width: 150px;\n"
				+ "    			height: 150px;\n"
				+ "    			object-fit: cover;\n"
				+ "    			margin: 10px auto;\n"
				+ "    			border: 10px solid #ccc;\n"
				+ "    			border-radius: 50%;\n"
				+ "			}\n"
				+ "			.student-profile .card h3 {\n"
				+ "    			font-size: 20px;\n"
				+ "    			font-weight: 700;\n"
				+ "			}\n"
				+ "			.student-profile .card p {\n"
				+ "    			font-size: 16px;\n"
				+ "    			color: #000;\n"
				+ "			}\n"
				+ "			.student-profile .table th,.student-profile .table td {\n"
				+ "    			font-size: 14px;\n"
				+ "    			padding: 5px 10px;\n"
				+ "    			color: #000;\n"
				+ "			}\n"
				+ "			.button {\n"
				+ "    			background-color: #555555;\n"
				+ "    			border: none;\n"
				+ "    			color: white;\n"
				+ "    			padding: 15px 32px;\n"
				+ "    			text-align: center;\n"
				+ "    			text-decoration: none;\n"
				+ "    			display: inline-block;\n"
				+ "    			font-size: 16px;\n"
				+ "    			top:10px;\n"
				+ "    			position: relative;\n"
				+ "    			left: 1200px;\n"
				+ "  			}\n"
				+ "  		</style>	\n"
				+ "	</head>");
		out.println("<body>\n"
				+ "		<div class=\"ScriptTop\">\n"
				+ "    		<div class=\"rt-container\">\n"
				+ "        		<div class=\"col-rt-4\" id=\"float-right\">\n"
				+ "            		<a href=\"faculty_home\"><button class=\"button\" type=\"button\">Faculty Home</button></a> \n"
				+ "        		</div>\n"
				+ "            	\n"
				+ "    		</div>\n"
				+ "		</div>\n"
				+ "		<section>\n"
				+ "    		<div class=\"rt-container\">\n"
				+ "          		<div class=\"col-rt-12\">\n"
				+ "              		<div class=\"Scriptcontent\">\n"
				+ "						<div class=\"student-profile py-4\">\n"
				+ "  							<div class=\"container\">\n"
				+ "    							<div class=\"row\">\n"
				+ "      								<div class=\"col-lg-4\">\n"
				+ "        								<div class=\"card shadow-sm\">\n"
				+ "          									<div class=\"card-header bg-transparent text-center\">\n"
				+ "            									<img class=\"profile_img\" src=\"https://source.unsplash.com/600x300/?student\" alt=\"student dp\">\n"
				+ "            									<h3>");
		out.println("Sandeep Reddy");//name of faculty 
		out.println("</h3>\n"
				+ "          									</div>\n"
				+ "          									<div class=\"card-body\">\n"
				+ "            									<p class=\"mb-0\"><strong class=\"pr-1\">Faculty ID</strong>");
		out.println("2");//id of faculty 
		out.println("</p>\n"
				+ "            									<p class=\"mb-0\"><strong class=\"pr-1\">Branch</strong>");
		out.println("CSE");//branch of faculty )
		out.println("</div>\n"
				+ "        								</div>\n"
				+ "      								</div>\n"
				+ "      								<div class=\"col-lg-8\">\n"
				+ "        							<div class=\"card shadow-sm\">\n"
				+ "          							<div class=\"card-header bg-transparent border-0\">\n"
				+ "            							<h3 class=\"mb-0\"><i class=\"far fa-clone pr-1\"></i>General Information</h3>\n"
				+ "          							</div>\n"
				+ "          							<div class=\"card-body pt-0\">\n"
				+ "            							<table class=\"table table-bordered\">\n"
				+ "              								<tr>\n"
				+ "                								<th width=\"30%\">Specialized areas</th>\n"
				+ "                								<td width=\"2%\">:</td>\n"
				+ "                								<td>");
		
		out.println("Machine learning");//specialized areas 
		out.println("</td>\n"
				+ "              								</tr>\n"
				+ "              								<tr>\n"
				+ "                								<th width=\"30%\">Total number of publications</th>\n"
				+ "                								<td width=\"2%\">:</td>\n"
				+ "                								<td>");
		out.println("0");//total publications
		out.println("</td>\n"
				+ "              								</tr>\n"
				+ "            							</table>\n"
				+ "          							</div>\n"
				+ "        						</div>\n"
				+ "");
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/faculty_profile.jsp");
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
