package com.dao;

public interface IImageDAO {
	String imaxbid="SELECT nvl(MAX(bid),0) FROM imageboard"; 
	String iinsert="insert into imageboard(bid,ititle,savefilename) values(?,?,?)";
	
	//파일데이터 전체 조회 (서브쿼리...?)
	
	String ifind = "select bid,ititle,savefilename from imageboard where bid=?";
	String idelete = "delete from imageboard where bid=?";
	
	//데이터 카운트
	String icount = "select nvl(count(*),0) from imageboard";
	
}
