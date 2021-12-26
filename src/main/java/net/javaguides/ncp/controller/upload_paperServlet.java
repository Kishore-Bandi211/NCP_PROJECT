package net.javaguides.ncp.controller;
import net.javaguides.ncp.model.*;
import java.io.IOException;

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
@WebServlet("/uploadpaper")
public class upload_paperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private upload_paperDao upload_paperdao = new upload_paperDao();
	public upload_paper paper= new upload_paper();

    public upload_paperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/upload_paper.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String publication_id=request.getParameter("roll_number")+"_"+request.getParameter("title_paper");
		
		String student_name = request.getParameter("student_name");
		String roll_number = request.getParameter("roll_number");
		String email = request.getParameter("student_email");
		String faculty_name = request.getParameter("faculty_name");
		String title_paper = request.getParameter("title_paper");
		String conference_details = request.getParameter("conference_details");
		
		String submission_date = request.getParameter("submission_date");
		String acceptance_date = request.getParameter("acceptance_date");
		String link_publication = request.getParameter("link_publication");
		String proof_approval = request.getParameter("proof_approval");
		
		System.out.println(student_name);
		System.out.println(submission_date);
		System.out.println(proof_approval);
		
		paper.setStudent_name(student_name);
		paper.setRoll_number(roll_number);
		paper.setEmail(email);
		paper.setFaculty_name(faculty_name);
		paper.setTitle(title_paper);
		paper.setJournal(proof_approval);
		paper.setSubmission(submission_date);
		paper.setAcceptance(acceptance_date);
		paper.setLink(link_publication);
		paper.setPublicationId(publication_id);
		
		
		

		
		try {
			upload_paperdao.registerEmployee(paper);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student_home.jsp");
		dispatcher.forward(request, response);
	}

}
