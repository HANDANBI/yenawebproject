package com.biz;

import java.sql.*;
import java.util.List;

import com.vo.*;
import com.dao.*;
import static common.JDBCTemplate.*;

public class ImageBIZ {
	
	//파일 데이터 입력하기
	public void insertData(ImageVO vo) {
		Connection con = getConnection();
		new ImageDAO(con).insertData(vo);
		Close(con);
	}
	//파일 전체 조회하기
	public List<ImageVO> getList(int start,int end){
		Connection con = getConnection();
		List<ImageVO> res = new ImageDAO(con).getList(start,end);
		Close(con);
		return res;	
	}
	//데이터 조회
	public ImageVO getReadData(int num) {
		Connection con = getConnection();
		ImageVO res = new ImageDAO(con).getReadData(num);
		Close(con);
		return res;
	}
	//파일데이터 삭제
	public void deleteData(int num) {
		Connection con = getConnection();
		new ImageDAO(con).deleteData(num);
		Close(con);
	}
	//데이터 카운트
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
