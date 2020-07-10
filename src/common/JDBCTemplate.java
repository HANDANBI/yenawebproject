package common;

import java.sql.*;

///////////////////Connection & Close & Commit & rollback
public class JDBCTemplate {
	//연결한 상태로 리턴해주겠다. 
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//설치된 오라클 드라이버를 참조시킨다.
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String id ="big5";
		String pwd ="admin1234";
		
		Connection con=null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);//db는 오토커밋 하려고 함
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//접속하고 연결했다.
		return con;
		
	}
	//연결한 상태를  close()하겠다.
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
