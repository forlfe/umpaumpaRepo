package com.umpaumpa.team;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TeamDao {
	
	public static void rankCheck(TeamVo vo, Connection conn) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT MEMBER_NUM, TEAM_CODE FROM TEAM_JOIN T JOIN JOIN J ON T.MEMBER_NUM = J.NUM WHERE TEAM_CODE = ?";
			
			
		}finally {
			
		}
		
		//SQL 담을 객체
		
		
	}

}
