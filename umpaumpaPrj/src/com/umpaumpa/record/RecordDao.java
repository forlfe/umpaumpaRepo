package com.umpaumpa.record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;

public class RecordDao {
	/*
	 * 개인 기록 조회 
	 * 
	 * 
	 */
	
	public List<RecordVo> showRecord (Connection conn) throws Exception {
		//conn
		
		//sql 준비 >> 그 사람 기록만 조회하게 하고 싶은데 안되네요.....
			String sql = "SELECT R.NUMREC, J.NICK, R.NUM, R.KCAL, S.S_NAME, R.MIN FROM RECORD R JOIN JOIN J ON R.NUM = J.NUM JOIN STROKE_INFO S ON S.STROKE_NO = R.STROKE_NO" ;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<RecordVo> recordVoList = new ArrayList<RecordVo>();
			
		try {
			//sql 객체에 담기 및 쿼리 완성하기
			pstmt = conn.prepareStatement(sql);
			
			
			//sql 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			
			//resultset - > 자바 객체
		while (rs.next()) {
			
				int numrec = rs.getInt("NUMREC");
				String nick = rs.getString("NICK");
				int num = rs.getInt("NUM");
				int kcal = rs.getInt("KCAL");
				String sName = rs.getString("S_NAME");
				int min = rs.getInt("MIN");
				
				RecordVo vo = new RecordVo();
				vo.setNumrec(numrec);
				vo.setNick(nick);
				vo.setNum(num);
				vo.setKcal(kcal);
				vo.setMin(min);
				
				recordVoList.add(vo);
				
			}
			
		//}catch(Exception e) {
		//	e.printStackTrace();
		//	throw e;
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		
		return recordVoList;
		
	}//showRecord
	
}//class
