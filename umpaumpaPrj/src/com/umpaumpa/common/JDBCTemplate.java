package com.umpaumpa.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	

		//커넥션 가져오기
		public static Connection getConnection() throws Exception {
			// TODO Auto-generated method stub
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "C##MINI";
			String pwd = "MINI";
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
			
			return conn;
		}
		
		
		public static void close(Connection conn) {
			
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void close(ResultSet rs) {
				
				try {
					if(rs != null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		
		public static void close(Statement stmt) {
			
				try {
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}


		public static void rollback(Connection conn) {
			// TODO Auto-generated method stub
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void commit(Connection conn) {
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//커밋
		//conn.commit();

}
