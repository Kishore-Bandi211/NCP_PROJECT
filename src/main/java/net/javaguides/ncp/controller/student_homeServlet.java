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
@WebServlet("/student_home")
public class student_homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private feedbackDao feedbackdao = new feedbackDao();
    public student_homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student_home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				+ "    <meta charset=\"UTF-8\" />\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"> \n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n"
				+ "    <title>Student details</title>\n"
				+ "\n"
				+ "    <meta name=\"author\" content=\"Codeconvey\" />\n"
				+ "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap\" rel=\"stylesheet\"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>\n"
				+ "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css'>\n"
				+ "\n"
				+ "   \n"
				+ "    \n"
				+ "	   <style>\n"
				+ "	   body {\n"
				+ "    background: #67B26F;  /* fallback for old browsers */\n"
				+ "    background: -webkit-linear-gradient(to right, #4ca2cd, #67B26F);  /* Chrome 10-25, Safari 5.1-6 */\n"
				+ "    background: linear-gradient(to right, #4ca2cd, #67B26F); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n"
				+ "    padding: 0;\n"
				+ "    margin: 0;\n"
				+ "    font-family: 'Lato', sans-serif;\n"
				+ "    color: #000;\n"
				+ "}\n"
				+ "\n"
				+ ".student-profile .card {\n"
				+ "    border-radius: 10px;\n"
				+ "}\n"
				+ "\n"
				+ ".student-profile .card .card-header .profile_img {\n"
				+ "    width: 150px;\n"
				+ "    height: 150px;\n"
				+ "    object-fit: cover;\n"
				+ "    margin: 10px auto;\n"
				+ "    border: 10px solid #ccc;\n"
				+ "    border-radius: 50%;\n"
				+ "}\n"
				+ "\n"
				+ ".student-profile .card h3 {\n"
				+ "    font-size: 20px;\n"
				+ "    font-weight: 700;\n"
				+ "}\n"
				+ "\n"
				+ ".student-profile .card p {\n"
				+ "    font-size: 16px;\n"
				+ "    color: #000;\n"
				+ "}\n"
				+ "\n"
				+ ".student-profile .table th,\n"
				+ ".student-profile .table td {\n"
				+ "    font-size: 14px;\n"
				+ "    padding: 5px 10px;\n"
				+ "    color: #000;\n"
				+ "}\n"
				+ ".button {\n"
				+ "    background-color: #555555; /* Green */\n"
				+ "    border: none;\n"
				+ "    color: white;\n"
				+ "    padding: 15px 32px;\n"
				+ "    text-align: center;\n"
				+ "    text-decoration: none;\n"
				+ "    display: inline-block;\n"
				+ "    font-size: 16px;\n"
				+ "    top:10px;\n"
				+ "    position: relative;\n"
				+ "    left: 1200px;\n"
				+ "  }</style>\n"
				+ "</head>\n"
				+ "");
		out.println("<body>\n"
				+ "		\n"
				+ "<div class=\"ScriptTop\">\n"
				+ "    <div class=\"rt-container\">\n"
				+ "        <div class=\"col-rt-4\" id=\"float-right\">\n"
				+ " \n"
				+ "            <!-- Ad Here -->\n"
				+ "            <a href=\"student_home\"><button class=\"button\" type=\"button\">Student Home</button></a>\n"
				+ "            \n"
				+ "        </div>\n"
				+ "        <!-- <div class=\"col-rt-2\">\n"
				+ "            <ul>\n"
				+ "                <li><a href=\"https://codeconvey.com/html-code-for-student-profile\" title=\"Back to tutorial page\">Back to Tutorial</a></li>\n"
				+ "            </ul>\n"
				+ "        </div> -->\n"
				+ "    </div>\n"
				+ "</div>\n"
				+ "\n"
				+ "<!-- <header class=\"ScriptHeader\">\n"
				+ "    <div class=\"rt-container\">\n"
				+ "    	<div class=\"col-rt-12\">\n"
				+ "        	<div class=\"rt-heading\">\n"
				+ "            	<h1>Student Profile Page Design Example</h1>\n"
				+ "                <p>A responsive student profile page design.</p>\n"
				+ "            </div>\n"
				+ "        </div>\n"
				+ "    </div>\n"
				+ "</header> -->\n"
				+ "\n"
				+ "<section>\n"
				+ "    <div class=\"rt-container\">\n"
				+ "          <div class=\"col-rt-12\">\n"
				+ "              <div class=\"Scriptcontent\">\n"
				+ "              \n"
				+ "<!-- Student Profile -->\n"
				+ "<div class=\"student-profile py-4\">\n"
				+ "  <div class=\"container\">\n"
				+ "    <div class=\"row\">\n"
				+ "      <div class=\"col-lg-4\">\n"
				+ "        <div class=\"card shadow-sm\">\n"
				+ "          <div class=\"card-header bg-transparent text-center\">\n"
				+ "            <img class=\"profile_img\" src=\"https://source.unsplash.com/600x300/?student\" alt=\"student dp\">\n"
				+ "            <h3>");
		out.println("Student name");//student name 
		out.println("</h3>\n"
				+ "          </div>\n"
				+ "          <div class=\"card-body\">\n"
				+ "            <p class=\"mb-0\"><strong class=\"pr-1\">Roll number</strong>");
		out.println("cb.en.u4cse18502");
		out.println("</p>\n"
				+ "            <p class=\"mb-0\"><strong class=\"pr-1\">Branch</strong>");
		out.println("CSE");//branch 
		out.println("</p>\n"
				+ "            <p class=\"mb-0\"><strong class=\"pr-1\">Graduating year</strong>");
		out.println("2022");//graduating year 
		out.println("</p>\n"
				+ "          </div>\n"
				+ "        </div>\n"
				+ "      </div>\n"
				+ "      <div class=\"col-lg-8\">\n"
				+ "        <div class=\"card shadow-sm\">\n"
				+ "          <div class=\"card-header bg-transparent border-0\">\n"
				+ "            <h3 class=\"mb-0\"><i class=\"far fa-clone pr-1\"></i>General Information</h3>\n"
				+ "          </div>\n"
				+ "          <div class=\"card-body pt-0\">\n"
				+ "            <table class=\"table table-bordered\">\n"
				+ "              <tr>\n"
				+ "                <th width=\"30%\">Number of publications</th>\n"
				+ "                <td width=\"2%\">:</td>\n"
				+ "                <td>");
		out.println("3");//total number of publications 
		out.println("</td>\n"
				+ "              </tr>\n"
				+ "              <tr>\n"
				+ "                <th width=\"30%\">Class advisor</th>\n"
				+ "                <td width=\"2%\">:</td>\n"
				+ "                <td>");
		out.println("vishva kumar");//class advisor 
		out.println("</td>\n"
				+ "              </tr>\n"
				+ "              <tr>\n"
				+ "                <th width=\"30%\">Current CGPA</th>\n"
				+ "                <td width=\"2%\">:</td>\n"
				+ "                <td>");
		out.println("8");//cgpa 
		out.println("</td>\n"
				+ "              </tr>\n"
				+ "            </table>\n"
				+ "          </div>\n"
				+ "        </div>\n"
				+ "");
		
	}

}
