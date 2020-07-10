package com.dao;

import static common.JDBCTemplate.Commit;
import static common.JDBCTemplate.Rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vo.LoginVO;

public class LoginDAO implements ILoginDAO {
private Connection conn;
	
	public LoginDAO(Connection conn) {
		this.conn=conn;
	}
	public LoginVO getLogin(LoginVO login) {
		//id pw name email addr
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		LoginVO login_res=null;
		try {
			pstm=conn.prepareStatement(mlogin);
			pstm.setString(1, login.getId());
			pstm.setString(2, login.getPw());
			rs = pstm.executeQuery();
			while(rs.next()) {
				login_res =new LoginVO(rs.getString(1),rs.getString(2));
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return login_res;
	}
	//전체출력
	public List<LoginVO> getMyLoginAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LoginVO booklogin = null;
		List<LoginVO> all = new ArrayList<LoginVO>();
		
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(mlist);
			while(rs.next()) {
				booklogin = new LoginVO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
				all.add(booklogin);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return all;
	}
	public boolean getMyLoginInsert(LoginVO login) {
		PreparedStatement pstm = null;
		boolean fw=false;
		try {
			pstm=conn.prepareStatement(minsert);
			pstm.setString(1, login.getId());
			pstm.setString(2, login.getPw());
			pstm.setString(3, login.getName());
			pstm.setString(4, login.getEmail());
			int rs = pstm.executeUpdate();
			if(rs > 0) {
				fw=true;
			}else {
				fw=false;
			}
		}catch(Exception e) {
			Rollback(conn);
			System.out.println(e);
		}finally {
			Commit(conn);
		}
		return fw;
				
	}
	public boolean getMyLoginUpdate(LoginVO login) {
		PreparedStatement pstm = null;
		boolean fw=false;
		try {
			//"update mylogin set name=?,email=? where id=?";
			pstm=conn.prepareStatement(mupdate);
			pstm.setString(1, login.getName());
			pstm.setString(2, login.getEmail());
			pstm.setString(3, login.getId());
			int rs = pstm.executeUpdate();
			if(rs > 0) {
				fw=true;
			}else {
				fw=false;
			}
		}catch(Exception e) {
			Rollback(conn);
			System.out.println(e);
		}finally {
			Commit(conn);
		}
		return fw;
	}
	public boolean getMyLoginDelete(LoginVO login) {
		PreparedStatement pstm = null;
		boolean fw=false;
		try {
			pstm=conn.prepareStatement(mdelete);
			pstm.setString(1, login.getId());
			
			int rs = pstm.executeUpdate();
			if(rs > 0) {
				fw=true;
			}else {
				fw=false;
			}
		}catch(Exception e) {
			Rollback(conn);
			System.out.println(e);
		}finally {
			Commit(conn);
		}
		return fw;
	}
	public LoginVO getMyLoginFind(LoginVO login) {
		//입력한 ID로 객체를 찾아서 리턴
		PreparedStatement pstm = null;
		ResultSet rs = null;
		LoginVO login_res=null;
		try {
			pstm=conn.prepareStatement(mfind);
			pstm.setString(1, login.getId());
			rs = pstm.executeQuery();
			while(rs.next()) {
				login_res =new LoginVO(rs.getString(1),rs.getString(2));
				login_res.setEmail(rs.getString("email"));
				login_res.setName(rs.getString("name"));
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return login_res;
	}
	public boolean tryLogin(String myID, String myPW) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		LoginVO login_res=null;
		try {
			pstm=conn.prepareStatement(mlogin);
			pstm.setString(1, myID);
			pstm.setString(2, myPW);
			rs = pstm.executeQuery();
			if(rs.next()) {
				//login_res =new LoginVO(rs.getString(1),rs.getString(2));
			}
			else {
				return false;
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}
	
	public String getName(String myID) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String res = null;
		try {
			pstm=conn.prepareStatement(mgetname);
			pstm.setString(1, myID);
			rs = pstm.executeQuery();
			if(rs.next()) {
				res = rs.getString(1);
			}
			else {
				res = null;
			}		
		}catch(Exception e) {
			System.out.println(e);
		}
		return res;
	}
}
