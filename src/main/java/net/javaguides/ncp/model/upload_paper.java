package net.javaguides.ncp.model;

public class upload_paper {
	private String publication_id;
	private String student_name;
	private String roll_number;
	private String email;
	private String faculty_name;
	private String title;
	private String journal;
	private String submission;
	private String acceptance;
	private String Link;
	private int grace_marks;
	
	public String getPublication_id() {
		return publication_id;
	}
	public void setPublication_id(String publication_id) {
		this.publication_id = publication_id;
	}
	public int getGrace_marks() {
		return grace_marks;
	}
	public void setGrace_marks(int grace_marks) {
		this.grace_marks = grace_marks;
	}
	public String getPublicationId() {
		return publication_id;
	}
	public void setPublicationId(String id) {
		this.publication_id = id;
	}
	
	
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String student_email) {
		this.email = student_email;
	}
	
	public String getRoll_number() {
		return roll_number;
	}
	public void setRoll_number(String roll_number) {
		this.roll_number = roll_number;
	}
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getSubmission() {
		return submission;
	}
	public void setSubmission(String submission) {
		this.submission = submission;
	}
	public String getAcceptance() {
		return acceptance;
	}
	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	
}
