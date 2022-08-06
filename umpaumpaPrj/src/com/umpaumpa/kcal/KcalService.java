package com.umpaumpa.kcal;

import java.sql.Connection;

import com.umpaumpa.common.JDBCTemplate;

public class KcalService {

	public int Calla(double Kresult, int min,String input, int num) {

		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = new KcalDao().Calla(Kresult, min,input,num, conn);
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		} catch (Exception e) {
			//롤백해야하는 상황
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
		
	}//Calla
}
