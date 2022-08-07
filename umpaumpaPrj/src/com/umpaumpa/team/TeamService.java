package com.umpaumpa.team;

import java.sql.Connection;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;

public class TeamService {

	
	public TeamVo teamRank(int num) {
		
		Connection conn = null;
		TeamVo vo = null;
		
		try {
			
			conn = JDBCTemplate.getConnection();
			vo = new TeamDao().showRank(num);
		} catch (Exception e) {
		}finally {
			JDBCTemplate.close(conn);
		}
		return vo;
	}
	

}
