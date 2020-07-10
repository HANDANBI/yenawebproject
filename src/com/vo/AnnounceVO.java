package com.vo;

public class AnnounceVO {
	private int aid; 
	private String awriter ;
	private String atitle;
	private String atext ;
	private String atime;
	
	public AnnounceVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnounceVO(int aid, String awriter, String atitle, String atext, String atime) {
		super();
		this.aid = aid;
		this.awriter = awriter;
		this.atitle = atitle;
		this.atext = atext;
		this.atime = atime;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAwriter() {
		return awriter;
	}

	public void setAwriter(String awriter) {
		this.awriter = awriter;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAtext() {
		return atext;
	}

	public void setAtext(String atext) {
		this.atext = atext;
	}

	public String getAtime() {
		return atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}
	
	
}
