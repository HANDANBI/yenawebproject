package com.vo;

public class ImageVO {
	private int bid;
	private String ititle;
	private String savefilename;
	
	public ImageVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageVO(int bid, String ititle, String savefilename) {
		super();
		this.bid = bid;
		this.ititle = ititle;
		this.savefilename = savefilename;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getItitle() {
		return ititle;
	}

	public void setItitle(String ititle) {
		this.ititle = ititle;
	}

	public String getSavefilename() {
		return savefilename;
	}

	public void setSavefilename(String savefilename) {
		this.savefilename = savefilename;
	}
	
	
}
