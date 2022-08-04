package com.umpaumpa.member;

import java.sql.Connection;

import com.umpaumpa.common.JDBCTemplate;

public class MemberService {

	public static int join(MemberVo vo, Connection conn) {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		//id check(id<4)
		int idcheck = vo.getId().length();
		
		if(idcheck<4) {
			
			System.out.println("아이디 수가 너무 적습니다.");
			return -1;
		}
		//pwd > 4
		int pwdcheck1 = vo.getPwd().length();
		if(pwdcheck1<4) {
			System.out.println("비밀번호 수가 너무 적습니다.");
			return -2;
		}
		//pwd1==pwd2
		if(vo.getPwd().equals(vo.getPwd2())==false) {
			System.out.println("비밀번호가 서로 일치하지 않습니다.");
			return -3;
		}
		
		try {
			conn=JDBCTemplate.getConnection();
			result = MemberDao.join(vo, conn);
			if(result==1) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 에러 발생");
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

}
