package com.dao;

public interface IImageDAO {
	String imaxbid="SELECT nvl(MAX(bid),0) FROM imageboard"; 
	String iinsert="insert into imageboard(bid,ititle,savefilename) values(?,?,?)";
	
	//���ϵ����� ��ü ��ȸ (��������...?)
	
	String ifind = "select bid,ititle,savefilename from imageboard where bid=?";
	String idelete = "delete from imageboard where bid=?";
	
	//������ ī��Ʈ
	String icount = "select nvl(count(*),0) from imageboard";
	
}
