package com.dao;

public interface IBoardDAO {
	String binsert="insert into bookboard(bid, writer,title,booktitle,text,genre,time,grade) values(?,?,?,?,?,?,sysdate,0)";
	String binsert2="INSERT INTO bookboard(writer,genre,TITLE,text,bid) VALUES(?,?,?,?,?)";
	String bdelete = "delete from bookboard where bid = ?";
	String bupdate = "update bookboard set title=?,booktitle=?,text=?,genre=? where bid=?";
	String bsetgrade = "update bookboard set Grade=? where Bid=?";
	
	String blist="select * from bookboard order by bid desc";
	String bfind= "select * from bookboard where bwriter=?";
	String bboard="select * from bookboard where genre =? ";
	String bview = "SELECT bid, writer, TITLE,booktitle, text,genre,TIME,grade FROM bookboard WHERE bid=?";
	String bcount="select COUNT(*) from bookboard ";
	String bmaxbid="SELECT MAX(bid) FROM bookboard"; 
	String bgetgrade="SELECT Grade FROM bookboard WHERE Bid=?";
}
