package com.biz;

import java.sql.*;
import java.util.List;

import com.vo.*;
import com.dao.*;
import static common.JDBCTemplate.*;

public class ImageBIZ {
	
	//���� ������ �Է��ϱ�
	public void insertData(ImageVO vo) {
		Connection con = getConnection();
		new ImageDAO(con).insertData(vo);
		Close(con);
	}
	//���� ��ü ��ȸ�ϱ�
	public List<ImageVO> getList(int start,int end){
		Connection con = getConnection();
		List<ImageVO> res = new ImageDAO(con).getList(start,end);
		Close(con);
		return res;	
	}
	//������ ��ȸ
	public ImageVO getReadData(int num) {
		Connection con = getConnection();
		ImageVO res = new ImageDAO(con).getReadData(num);
		Close(con);
		return res;
	}
	//���ϵ����� ����
	public void deleteData(int num) {
		Connection con = getConnection();
		new ImageDAO(con).deleteData(num);
		Close(con);
	}
	//������ ī��Ʈ
	public int getDataCount() {
		Connection con = getConnection();
		int res = new ImageDAO(con).getDataCount();
		Close(con);
		return res;
	}
	public int getMaxNum() {
		Connection con = getConnection();
		int res = new ImageDAO(con).getMaxNum();
		Close(con);
		return res;
	}
		
}
