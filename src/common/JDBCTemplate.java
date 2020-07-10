package common;

import java.sql.*;

///////////////////Connection & Close & Commit & rollback
public class JDBCTemplate {
	//������ ���·� �������ְڴ�. 
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��ġ�� ����Ŭ ����̹��� ������Ų��.
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String id ="big5";
		String pwd ="admin1234";
		
		Connection con=null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);//db�� ����Ŀ�� �Ϸ��� ��
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�����ϰ� �����ߴ�.
		return con;
		
	}
	//������ ���¸�  close()�ϰڴ�.
	public static void Close(Connection con) {
		try {
			if(!con.isClosed() && con !=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void Close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void Close(ResultSet rs) {
		try {
			if(rs !=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void Commit(Connection con) {
		try {
			if( con !=null && !con.isClosed() ) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void Rollback(Connection con) {
		try {
			if(con !=null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
