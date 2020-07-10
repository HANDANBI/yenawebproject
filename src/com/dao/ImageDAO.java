package com.dao;


import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vo.*;

public class ImageDAO implements IImageDAO{
	private Connection conn=null;
	
	public ImageDAO(Connection conn) {
		this.conn=conn;
	}
	
	public void SetConnection(Connection conn) {
		this.conn=conn;
	}
	
	//번호찾기
	public int getMaxNum() {
		int maxNum=0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try { 
			pstmt = conn.prepareStatement(imaxbid); 
			rs = pstmt.executeQuery(); 
			if(rs.next()) { 
				maxNum=rs.getInt(1); 
			} 
			else {
				maxNum=1;
			}
		rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return maxNum;
	}
	
	//파일 데이터 입력하기
	public void insertData(ImageVO vo) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(iinsert);
			
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getItitle());
			pstmt.setString(3,vo.getSavefilename());
			
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//파일 전체 조회하기
	public List<ImageVO> getList(int start,int end){
		
		List<ImageVO> lists = new ArrayList<ImageVO>();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			sql = "select * from (select rownum as rnum ,bid,ititle,savefilename";
			sql += " from imageboard order by bid desc)";
			sql += " where rnum >=? and rnum <=?";
			
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ImageVO vo = new ImageVO();
				vo.setBid(rs.getInt("bid"));
				vo.setItitle(rs.getString("ititle"));
				vo.setSavefilename(rs.getString("savefilename"));
				lists.add(vo);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return lists;
	}
	
	//데이터 조회
	public ImageVO getReadData(int num) {
		ImageVO vo = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt = conn.prepareStatement(ifind);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ImageVO();
				vo.setBid(rs.getInt("bid"));
				vo.setItitle(rs.getString("ititle"));
				vo.setSavefilename(rs.getString("savefilename"));
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return vo;
	}
	
	//파일데이터 삭제
	public void deleteData(int num) {
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(idelete);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//데이터 카운트
	public int getDataCount() {
		
		int total = 0;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(icount);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
				
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return total;
	}
}
