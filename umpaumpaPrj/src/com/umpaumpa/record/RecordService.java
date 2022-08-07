package com.umpaumpa.record;

import java.sql.Connection;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;

public class RecordService {
	
	public List<RecordVo> showList() {
		Connection conn = null;
		List<RecordVo> recordVoList = null;
		
		
		try {
			conn = JDBCTemplate.getConnection();
			recordVoList = new RecordDao().showRecord(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return recordVoList;

}//showlist
	
	
	
	public RecordVo showDetailByNo(int num) {
		
		Connection conn = null;
		RecordVo vo1 = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			vo1 = new RecordDao().showDetailByNo(conn, num);
		}catch (Exception e) {
			System.out.println("[ERROR] 운동 기록 상세 조회 중 예외 발생 !!! ");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return vo1;
	}
	
}//class
