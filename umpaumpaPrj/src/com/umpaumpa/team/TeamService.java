package com.umpaumpa.team;

import java.sql.Connection;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;

public class TeamService {

	
	public TeamVo rank(int num) {
		
		Connection conn = null;
		TeamVo vo = null;
		
		try {
			
			conn = JDBCTemplate.getConnection();
			vo = new TeamDao().showRank(conn, num);
			
		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
		}finally {
			JDBCTemplate.close(conn);
		}
		return vo;
	}
	

}
