package com.umpaumpa.kcal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.umpaumpa.common.JDBCTemplate;
import com.umpaumpa.main.Main;

public class KcalDao {
	
	
	public int Calla(double Kresult, int min,String input,int num, Connection conn)throws Exception {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String no = Main.loginMember.getNo();
		
		if(input.equals("Y")||input.equals("y")) {
			try {
				//sql준비
				String sql = "INSERT INTO RECORD(KCAL, MIN, SWIMDATE,NUMREC, NUM,STROKE_NO) VALUES(?,?,SYSDATE,SEQ_RECORD_NUMREC.NEXTVAL,?,?)";
				
				//sql 담을 객체 만들기
				pstmt = conn.prepareStatement(sql);
				pstmt.setDouble(1,Kresult);
				pstmt.setInt(2,min);
				pstmt.setString(3,no);
				pstmt.setInt(4,num);
				
				//sql 실행 및 결과 저장
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				throw e;
			}
			finally {
				JDBCTemplate.close(pstmt);
			}
		}else if(input.equals("N")||input.equals("n")){
			System.out.println("메인 화면으로 돌아갑니다.");//main화면으로
			return result;//+++++++++++이부분+++++++++++++//
		}
		
		return result;
	}//Calla

}//class
