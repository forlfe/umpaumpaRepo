package com.umpaumpa.team;

import java.sql.Connection;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;

public class TeamService {
	
	public List<TeamVo> TeamService() {
		Connection conn = null;
		List<TeamVo> teamVoList = null;
		
		try {
			conn = JDBCTemplate.getConnection();
//			teamVoList = new TeamDao().rankCheck(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return teamVoList;
	}

}
