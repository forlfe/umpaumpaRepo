package com.umpaumpa.team;

import java.sql.Connection;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;
import com.umpaumpa.record.RecordVo;
import com.umpaumpa.teamjoin.TeamJoinVo;

public class TeamService {

	
	public TeamVo teamRank(int num) {
		
		Connection conn = null;
		TeamVo vo = new TeamVo();
		
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
