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
			result = new TeamJoinDao().join(vo ,conn);
			
			if(result == 1) {
				System.out.println("팀가입 성공!");
				JDBCTemplate.commit(conn);
			}else {
				System.out.println("팀가입 실패...");
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


}