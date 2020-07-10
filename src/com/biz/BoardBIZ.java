package com.biz;

import java.sql.*;
import java.util.List;

import com.vo.*;
import com.dao.*;
import static common.JDBCTemplate.*;

public class BoardBIZ {
	public List<BoardVO> getBoardALL(){
		Connection con = getConnection();
		List<BoardVO> res = new BoardDAO(con).getBoardALL();
		Close(con);
		return res;
	}
	
	public boolean insertBoard(BoardVO board) {
		boolean res = false;
		Connection con = getConnection();
		res = new BoardDAO(con).insertBoard(board);
		Close(con);
		return res;
	}
	
	public int getBoardCount() {
		Connection con = getConnection();
		int res = new BoardDAO(con).getBoardCount();
		Close(con);
		return res;
	}
	
	public boolean deleteBoard(int bid) {
		Connection con = getConnection();
		boolean res = new BoardDAO(con).deleteBoard(bid);
		Close(con);
		return res;
	}
	public void getBoardUpdate(BoardVO board) {
		
	}
	public BoardVO getBoardFind(BoardVO board) {
		Connection con = getConnection();
		BoardVO res = new BoardDAO(con).getBoardFind(board);
		Close(con);
		return res;
	}
	public BoardVO getView(int idx) {
		Connection con = getConnection();
		BoardVO res = new BoardDAO(con).getView(idx);
		Close(con);
		return res;
	}
	public void insertWrite(BoardVO vo, int max) {
		Connection con = getConnection();
		new BoardDAO(con).insertWrite(vo, max);
		Close(con);
	}
	public void plusGrade(int bid) {
		Connection con = getConnection();
		new BoardDAO(con).plusGrade(bid);
		Close(con);
	}

	public boolean updateBoard(BoardVO board) {
		boolean res = false;
		Connection con = getConnection();
		res = new BoardDAO(con).updateBoard(board);
		Close(con);
		return res;
	}
	
}
