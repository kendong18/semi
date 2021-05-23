package com.semi.dto;

public class QuestionDTO {
	
	private int q_no = 0;
	private String q_title = null;
	private String co_id = null;
	private String q_content = null;
	private String q_comment = null;
	
	
	public QuestionDTO() {
	}


	public int getQ_no() {
		return q_no;
	}


	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}


	public String getQ_title() {
		return q_title;
	}


	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}


	public String getCo_id() {
		return co_id;
	}


	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}


	public String getQ_content() {
		return q_content;
	}


	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}


	public String getQ_comment() {
		return q_comment;
	}


	public void setQ_comment(String q_comment) {
		this.q_comment = q_comment;
	}
	
}
