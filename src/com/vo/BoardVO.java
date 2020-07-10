package com.vo;

public class BoardVO {
	private int bid; 
	private String bwriter ;
	private String title;
	private String text ;
	private String time;
	private String booktitle ;
	private String genre ;
	private int grade;
	private boolean dayNew;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int bid, String time, String bwriter, String title, 
			String booktitle, String text, String genre, int grade) {
		super();
		this.bid = bid;
		this.bwriter = bwriter;
		this.title = title;
		this.text = text;
		this.time = time;
		this.booktitle = booktitle;
		this.genre = genre;
		this.grade = grade;
	}
	public BoardVO(int bid, String bwriter, String title, 
			String time, String booktitle, String genre, int grade) {
		super();
		this.bid = bid;
		this.bwriter = bwriter;
		this.title = title;
		this.time = time;
		this.booktitle = booktitle;
		this.genre = genre;
		this.grade = grade;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public boolean isDayNew() {
		return dayNew;
	}

	public void setDayNew(boolean dayNew) {
		this.dayNew = dayNew;
	}
	
	
}
