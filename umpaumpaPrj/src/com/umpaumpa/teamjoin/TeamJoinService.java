package com.umpaumpa.teamjoin;

import java.sql.Connection;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;
import com.umpaumpa.member.MemberVo;
import com.umpaumpa.team.TeamVo;

public class TeamJoinService {

	
	public int join(TeamJoinVo vo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = new TeamJoinDao().join(vo,conn);
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		} catch (Exception e) {
			//롤백해야하는 상황
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
	
	public List<TeamVo> teamShow() {
		Connection conn = null;
		List<TeamVo> TeamVoList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			TeamVoList = new TeamJoinDao().teamShow(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return TeamVoList;
		
	}

//	public List<TeamVo> joinTeamShow() {
//		
//		Connection conn = null;
//		List<TeamVo> TeamVoList = null;
//		try {
//			conn = JDBCTemplate.getConnection();
//			
//			TeamVoList = new TeamJoinDao().joinTeamShow(conn);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(conn);
//		}
//		
//		return TeamVoList;
//		
//	}


}
