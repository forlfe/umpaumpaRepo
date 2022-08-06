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
	
	
}//class
