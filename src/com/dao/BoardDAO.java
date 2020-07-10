package com.dao;

import static common.JDBCTemplate.Commit;
import static common.JDBCTemplate.Rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vo.BoardVO;

public class BoardDAO implements IBoardDAO{
	private Connection conn;
	
	public BoardDAO(Connection conn) {
		this.conn=conn;
	}
	
	public void SetConnection(Connection conn) {
		this.conn=conn;
	}
	public String pasing(String data) { 
		try { 
			data = new String(data.getBytes("8859_1"), "euc-kr"); 
			}catch (Exception e){
				
			} return data; 
	}

	//전체 출력
	public List<BoardVO> getBoardALL(){
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO bookboard = null;
		List<BoardVO> all = new ArrayList<BoardVO>();
		
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(blist);
			while(rs.next()) {
				bookboard = new BoardVO(
						rs.getInt(1),rs.getString(2), 
						rs.getString(3),rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getInt(8));
			/*	String time = rs.getString(2);
				Date date = new Date();
				SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd"); 
				String year = (String)simpleDate.format(date);
				String yea = time.substring(0,10); 
				*/
				
				all.add(bookboard);
			} 
		
			/*
			while(rs.next()) {
			   BoardVO vo = new BoardVO();
			   boolean dayNew = false; 
			   vo.setBid(rs.getInt(1)); 
			   Date date = new Date(); 
			   SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd"); 
			   String year = (String)simpleDate.format(date); 
			   String yea = rs.getString(2).substring(0,10);
			   if(year.equals(yea)){ 
				   dayNew = true; 
			   } 
			   vo.setTime(yea); 
			   vo.setBwriter(rs.getString(3)); 
			   vo.setTitle(rs.getString(4));
			   vo.setBooktitle(rs.getString(5));
			   vo.setText(rs.getString(6));
			   vo.setGenre(rs.getString(7));
			   vo.setGrade(rs.getInt(8));
			   vo.setDayNew(dayNew);
			   
			   all.add(vo);
			   }

			*/
			
			rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return all;
	}
	
	//추가(insert)
	/*int bid, String bwriter, String title, String text, 
	String time, String booktitle, String genre, int grade*/
	public boolean insertBoard(BoardVO board) {
		PreparedStatement pstm = null;
		try {
			pstm=conn.prepareStatement(binsert);
			pstm.setInt(1, getNewBid());
			pstm.setString(2, board.getBwriter());
			pstm.setString(3, board.getTitle());
			pstm.setString(4, board.getBooktitle());
			pstm.setString(5, board.getText());
			pstm.setString(6, board.getGenre());
						
			pstm.execute();
		}catch(Exception e) {
			Rollback(conn);
			System.out.println(e);
			return false;
		}finally {
			Commit(conn);
		}	
		return true;
	}
	public void insertWrite(BoardVO vo, int max) {
		PreparedStatement pstmt = null; 
		try {  
			pstmt = conn.prepareStatement(binsert2); 
			pstmt.setString(1, pasing(vo.getBwriter()));
			pstmt.setString(2, pasing(vo.getGenre()));
			pstmt.setString(3, pasing(vo.getTitle()));
			pstmt.setString(4, pasing(vo.getText())); 
			pstmt.setInt(5, max+1); 
			pstmt.execute(); 
			}catch(Exception e) { 
				
			}finally {
				
			} 
		}

	
	//삭제(delete)
	public boolean deleteBoard(int bid) {
		PreparedStatement pstm=null;
		try {
			pstm=conn.prepareStatement(bdelete);
			pstm.setInt(1, bid);
			pstm.executeUpdate();
		}catch(Exception e) {
			Rollback(conn);
			System.out.println(e);
			return false;
		}finally {
			Commit(conn);
		}
		return true;
	}
	
	//수정(update)
	//String bupdate = "update bookboard set 
	//		title=?,booktitle=?,text=? where bwriter=?";
	/*
	 * public void getBoardUpdate(BoardVO board) { PreparedStatement pstm=null;
	 * 
	 * try { pstm=conn.prepareStatement(bupdate); pstm.setString(1,
	 * board.getTitle()); pstm.setString(2, board.getBooktitle()); pstm.setString(3,
	 * board.getText()); pstm.setString(4, board.getBwriter());
	 * pstm.executeUpdate();
	 * 
	 * }catch(Exception e) { Rollback(conn); System.out.println(e); }finally {
	 * Commit(conn); } }
	 */
	public boolean updateBoard(BoardVO board) {
		PreparedStatement pstm = null;
		try {
			pstm=conn.prepareStatement(bupdate);
			pstm.setString(1, board.getTitle());
			pstm.setString(2, board.getBooktitle());
			pstm.setString(3, board.getText());
			pstm.setString(4, board.getGenre());
			pstm.setInt(5, board.getBid());
						
			pstm.execute();
		}catch(Exception e) {
			Rollback(conn);
			System.out.println(e);
			return false;
		}finally {
			Commit(conn);
		}	
		return true;
	}
	
	//입력한 ID로 객체 찾아서 리턴
	public BoardVO getBoardFind(BoardVO board) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BoardVO board_res=null;
		try {
			pstm=conn.prepareStatement(bfind);
			pstm.setString(1, board.getBwriter());
			rs=pstm.executeQuery();
			while(rs.next()) {
				board_res= new BoardVO(rs.getInt(1),  rs.getString(2), rs.getString(3),rs.getString(4), 
						rs.getString(5), rs.getString(6),rs.getInt(7));
				board_res.setBid(rs.getInt("bid"));
				board_res.setBwriter(rs.getString("bwriter"));
				board_res.setTitle(rs.getString("title"));
				board_res.setTime(rs.getString("time"));
				board_res.setBooktitle(rs.getString("booktitle"));
				board_res.setGenre(rs.getString("genre"));
				board_res.setGrade(rs.getInt("grade"));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return board_res;
		
	}

	public BoardVO getView(int idx) {
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		BoardVO vo = null; 
		try { 
			 
			pstmt = conn.prepareStatement(bview); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery(); 
			if(rs.next()) { 
				vo = new BoardVO(); 
				vo.setBid(rs.getInt(1));
				vo.setBwriter(rs.getString(2)); 
				vo.setTitle(rs.getString(3)); 
				vo.setBooktitle(rs.getString(4));
				vo.setText(rs.getString(5)); 
				vo.setGenre(rs.getString(6)); 
				vo.setTime(rs.getString(7));
				vo.setGrade(rs.getInt(8));
				
				} }catch(Exception e) {
					
				}finally { 
					}
		return vo; 
		
		}

	public void plusGrade(int bid) {
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		int curGrade= 0; 
		try { 
			// 현제 grade 가져오기
			pstmt = conn.prepareStatement(bgetgrade); 
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery(); 
			if(rs.next()) { 
				curGrade=rs.getInt(1); 
			} 
			else {
				curGrade=-1;
			}
			rs.close();
			
			// +1한 값 넣어주기
			pstmt = conn.prepareStatement(bsetgrade); 
			pstmt.setInt(1, curGrade + 1);
			pstmt.setInt(2, bid);
			pstmt.executeUpdate(); 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public int getBoardCount() {
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(bcount);
			if(rs.next()) {
				count = rs.getInt(1);
			}else {
				count = 0;
			}
			rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return count;
	}
	public int getNewBid() { 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		int max = 0; 
		try { 
			pstmt = conn.prepareStatement(bmaxbid); 
			rs = pstmt.executeQuery(); 
			if(rs.next()) { 
				max=rs.getInt(1)+1; 
			} 
			else {
				max=1;
			}
		rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return max; 
	}



	
	
	
}
