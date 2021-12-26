package net.javaguides.ncp.model;

public class prev_publication {
	private String student_name;
	private String roll_number;
	private String title_paper;
	private String link_publication;
	private int grace_marks;
	
	
	public String getTitle_paper() {
		return title_paper;
	}
	public int getGrace_marks() {
		return grace_marks;
	}
	public void setGrace_marks(int grace_marks) {
		this.grace_marks = grace_marks;
	}
	public void setTitle_paper(String title_paper) {
		this.title_paper = title_paper;
	}
	public String getLink_publication() {
		return link_publication;
	}
	public void setLink_publication(String link_publication) {
		this.link_publication = link_publication;
	}
	public String getStudent_name() {
		return this.student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getRoll_number() {
		return this.roll_number;
	}
	public void setRoll_number(String roll_number) {
		this.roll_number = roll_number;
	}
	
	
}
