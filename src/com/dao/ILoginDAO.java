package com.dao;

public interface ILoginDAO {
	String minsert="insert into bookLogin values(?,?,?,?)";
	String mdelete = "delete from bookLogin where id = ?";
	String mupdate = "update bookLogin set name=?,email=? where id=?";
	
	
	String mlist="select * from bookLogin";
	String mfind= "select * from bookLogin where id=?";
	String mlogin="select * from bookLogin where id =? and pw =? ";
	String mgetname = "SELECT Name FROM booklogin WHERE id=?";
}
