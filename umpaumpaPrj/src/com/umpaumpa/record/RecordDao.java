package com.umpaumpa.record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;
import com.umpaumpa.main.Main;
import com.umpaumpa.util.Inpututil;

public class RecordDao {
/*
* 개인 기록 조회
*
*
*/


public List<RecordVo> showRecord (Connection conn) throws Exception {
	//conn

	//sql 준비 >> 

	String sql = "SELECT R.NUMREC , J.NICK , R.NUM , R.KCAL , S.S_NAME , R.MIN , R.SWIMDATE FROM RECORD R JOIN JOIN J ON R.NUM = J.NUM JOIN STROKE_INFO S ON S.STROKE_NO = R.STROKE_NO ORDER BY NUMREC DESC" ;

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
			Timestamp swimDate = rs.getTimestamp("SWIMDATE");

			RecordVo vo = new RecordVo();
			vo.setNumrec(numrec);
			vo.setNick(nick);
			vo.setNum(num);
			vo.setKcal(kcal);
			vo.setMin(min);
			vo.setSwimDate(swimDate);

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

/**/

/*
 *  상세 조회
 * 
 */

	public RecordVo showDetailByNo(Connection conn, int num) throws Exception {
		//connection 준비
		//sql 준비
		String sql = "SELECT R.NUMREC , J.NICK , R.NUM , R.KCAL , S.S_NAME , R.MIN , R.SWIMDATE FROM RECORD R JOIN JOIN J ON R.NUM = J.NUM JOIN STROKE_INFO S ON S.STROKE_NO = R.STROKE_NO WHERE NUMREC = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RecordVo vo1 = null;
		
		try {
			//sql 객체에 담기 및 쿼리 완성하기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			//sql 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			//ResultSet -> 자바 객체
			if(rs.next()) {
				
				int numrec = rs.getInt("NUMREC");
				String nick = rs.getString("NICK");
				int num1 = rs.getInt("NUM");
				int kcal = rs.getInt("KCAL");
				String sName = rs.getString("S_NAME");
				int min = rs.getInt("MIN");
				Timestamp swimDate = rs.getTimestamp("SWIMDATE");

				vo1 = new RecordVo();
				vo1.setNumrec(numrec);
				vo1.setNick(nick);
				vo1.setNum(num1);
				vo1.setKcal(kcal);
				vo1.setMin(min);
				vo1.setSwimDate(swimDate);
				vo1.setsName(sName);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		//실행 결과(자바 객체) 리턴
		
		return vo1;
}
	
	/*운동 기록 상세조회
	   public int showRecordDetailMenu() {
	      System.out.println("");
	      System.out.print("상세조회할 운동 번호를 입력하세요 (0번을 누르면 메인으로 이동합니다) :  ");
	      
	      return Inpututil.getint();
	   }
	   */



}//class