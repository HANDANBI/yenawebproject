package com.biz;

import java.sql.*;
import java.util.List;

import com.vo.*;
import com.dao.*;
import static common.JDBCTemplate.*;

public class LoginBIZ {
	//id pw����
	public LoginVO getLogin(LoginVO login) {
		Connection con = getConnection();
		LoginVO res = new LoginDAO(con).getLogin(login);
		Close(con);
		return res;
	}
	//��ü���
		public List<LoginVO> getMyLoginAll() {
			Connection con = getConnection();
			List<LoginVO> res = new LoginDAO(con).getMyLoginAll();
			Close(con);
			return res;
		}
		//ȸ������
		public boolean getMyLoginInsert(LoginVO login) {
			Connection con = getConnection();
			boolean res = new LoginDAO(con).getMyLoginInsert(login);
			Close(con);
			return res;
		}
		//ȸ������
		public boolean getMyLoginUpdate(LoginVO login) {
			Connection con = getConnection();
			boolean res = new LoginDAO(con).getMyLoginUpdate(login);
			Close(con);
			return res;
		}
		//ȸ������
		public boolean getMyLoginDelete(LoginVO login) {
			Connection con = getConnection();
			boolean res = new LoginDAO(con).getMyLoginDelete(login);
			Close(con);
			return res;
		}
		//ȸ��ã��
		public LoginVO getMyLoginFind(LoginVO login) {
			Connection con = getConnection();
			LoginVO res = new LoginDAO(con).getMyLoginFind(login);
			Close(con);
			return res;
		}
		public boolean tryLogin(String myID, String myPW) {
			Connection con = getConnection();
			boolean res = new LoginDAO(con).tryLogin(myID,myPW);
			Close(con);
			return res;
		}
		
		public String getName(String myID) {
			Connection con = getConnection();
			String res = new LoginDAO(con).getName(myID);
			Close(con);
			return res;
		}
}
