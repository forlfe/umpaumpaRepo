package com.umpaumpa.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.umpaumpa.common.JDBCTemplate;

public class MemberDao {

	public static int join(MemberVo vo, Connection conn) throws Exception {
			// TODO Auto-generated method stub
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			try {
			String sql = "INSERT INTO JOIN(NUM, ID, PWD, NAME, NICK, WEIGHT, GENDER, ENROLL_DATE, QUIT_YN,EDIT_DATE)"
					+ " VALUES(SEQ_JOIN_NUM.NEXTVAL,?,?,?,?,?,?,SYSDATE,'N',SYSDATE)";
			
			//SQL 담을 객체
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setString(5, vo.getWeight());
			pstmt.setString(6, vo.getGender());
			
			result=pstmt.executeUpdate();
			
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
			return result;
			
		}
	
		public static MemberVo login(String inputid, String inputpwd) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT NUM, ID, NAME, NICK, WEIGHT, GENDER FROM JOIN WHERE ID=? AND PWD=? AND QUIT_YN='N'";
		
		Connection conn = JDBCTemplate.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputid);
		pstmt.setString(2, inputpwd);
		
		//SQL 실행
		ResultSet rs = pstmt.executeQuery();
		MemberVo vo=null;
		
				
		//rs.next();
		if(rs.next()) {
			String num = rs.getString("NUM");
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			String nick = rs.getString("NICK");
			String weight = rs.getString("WEIGHT");
			String gender = rs.getString("GENDER");
			
			vo = new MemberVo();
			
			vo.setNo(num);
			vo.setId(id);
			vo.setName(name);
			vo.setNick(nick);
			vo.setWeight(weight);
			vo.setGender(gender);
		}
		return vo;
	}
}
