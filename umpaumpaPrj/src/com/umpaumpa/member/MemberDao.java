package com.umpaumpa.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
			pstmt.setDouble(5, vo.getWeight());
			pstmt.setString(6, vo.getGender());
			
			result=pstmt.executeUpdate();
			
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
			return result;
			
		}
	
		public static MemberVo login(String inputid, String inputpwd) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT J.NUM, J.ID, J.NAME, J.NICK, J.WEIGHT, J.GENDER, T.TEAM_CODE,T.TEAMNAME FROM JOIN J JOIN TEAM_JOIN T ON J.NUM = T.MEMBER_NUM WHERE ID=? AND PWD=? AND QUIT_YN='N'";
		  
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
			int weight = rs.getInt("WEIGHT");
			String gender = rs.getString("GENDER");
			String teamCode = rs.getString("TEAM_CODE");
			String teamName = rs.getString("TEAMNAME");
			
			vo = new MemberVo();
			
			vo.setNo(num);
			vo.setId(id);
			vo.setName(name);
			vo.setNick(nick);
			vo.setWeight(weight);
			vo.setGender(gender);
			vo.setTeamCode(teamCode);
			vo.setTeamName(teamName);
		}
		return vo;
	}
		
		public MemberVo adminLogin(String adminId, String adminPwd) throws Exception {
			
			Connection conn = JDBCTemplate.getConnection();
			
			String sql="SELECT ADMIN_ID, ADMIN_NAME FROM ADMIN WHERE ADMIN_ID = ? AND ADMIN_PWD = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPwd);
			
			ResultSet rs = pstmt.executeQuery();
			MemberVo vo = null;
			
			
			if(rs.next()) {
				
				
				String id = rs.getString("ADMIN_ID");
				String name = rs.getString("ADMIN_NAME");
				
				vo = new MemberVo();
				
				vo.setAdminId(id);
				vo.setAdminName(name);
				
			}
			
			return vo;
		}

		public List<MemberVo> memberSearch(){
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<MemberVo> memberVoList = new ArrayList<MemberVo>();
			try {
				conn = JDBCTemplate.getConnection();
				
				String sql="SELECT * FROM JOIN ";
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					String no = rs.getString("NUM");
					String id = rs.getString("ID");
					String pwd = rs.getString("PWD");
					String name = rs.getString("NAME");
					String nick = rs.getString("NICK");
					int weight = rs.getInt("WEIGHT");
					String gender = rs.getString("GENDER");
					Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
					String quitYn = rs.getString("QUIT_YN");
					Timestamp editDate = rs.getTimestamp("EDIT_DATE");
					
					
					
					MemberVo vo = new MemberVo();
					vo.setNo(no);
					vo.setId(id);
					vo.setPwd(pwd);
					vo.setName(name);
					vo.setNick(nick);
					vo.setWeight(weight);
					vo.setGender(gender);
					vo.setEnrollDate(enrollDate);
					vo.setQuitYn(quitYn);
					vo.setEditDate(editDate);
					
					
					memberVoList.add(vo);
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(conn);
				JDBCTemplate.close(pstmt);
				JDBCTemplate.close(rs);
			}
			
			
			return memberVoList;
			
			
			
			
		}
		
		public List<MemberVo> memberSearchDe(String memberNo) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<MemberVo> memberVoList = new ArrayList<MemberVo>();
			try {
				conn = JDBCTemplate.getConnection();
				String sql="SELECT * FROM JOIN WHERE NUM = ? ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberNo);
				
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					String no = rs.getString("NUM");
					String id = rs.getString("ID");
					String pwd = rs.getString("PWD");
					String nick = rs.getString("NICK");
					Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
					Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
					String quitYn = rs.getString("QUIT_YN");
					
					
					MemberVo vo = new MemberVo();
					vo.setNo(no);
					vo.setId(id);
					vo.setPwd(pwd);
					vo.setNick(nick);
					vo.setEnrollDate(enrollDate);
					vo.setModifyDate(modifyDate);
					vo.setQuitYn(quitYn);
					
					memberVoList.add(vo);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(conn);
				JDBCTemplate.close(pstmt);
				JDBCTemplate.close(rs);
			}
			
			return memberVoList;
			
			
		}
		
		public int updatePwd(String id, String newPwd,Connection conn) throws Exception {
			
			PreparedStatement pstmt= null;
			
			int result = 0;
			try {
				
				
				
				String sql = "UPDATE JOIN SET PWD = ? WHERE ID = ?";
				
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1, newPwd);
				pstmt.setString(2, id);
				
				result = pstmt.executeUpdate();
				
			}catch(Exception e){
				throw e;
			}finally {
				JDBCTemplate.close(pstmt);
			}
			
			return result;
		}
		public int updateNick(String id, String newNick, Connection conn) throws Exception {
			
			
			PreparedStatement pstmt = null;
			
			int result = 0;
			
			try {
				
				
				String sql = "UPDATE JOIN SET NICK = ? WHERE ID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newNick);
				pstmt.setString(2, id);
				
				result = pstmt.executeUpdate();
				
				
			}catch(Exception e) {
				throw e;
			}finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
			
			
		}
		
		public int updateWeight(String id, int newWeight, Connection conn) throws Exception {
			PreparedStatement pstmt = null;
			
			int result = 0;
			
			try {
				
				
				String sql = "UPDATE JOIN SET WEIGHT = ? WHERE ID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, newWeight);
				pstmt.setString(2, id);
				
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				throw e;
			}finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
			
		}

		public int write(MemberVo vo, Connection conn) throws Exception {
			
			int result =  0;
			PreparedStatement pstmt = null;
			
			try {
				String sql = "INSERT INTO COMMUNITY(POSTNUM,WRITE_DATE,TITLE,CONTENT) VALUES (?,SYSDATE,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getNo());
				pstmt.setString(2, vo.getTitle());
				pstmt.setString(3, vo.getContent());
				
				
				result = pstmt.executeUpdate();
				
				
			}finally {
				JDBCTemplate.close(pstmt);
			}
			
			return result;
			
			
		}
		
		public List<BoardVo> showList(Connection conn) throws Exception {
			// SQL 준비
			String sql = "SELECT C.POSTNUM, C.NUM2, C.WRITE_DATE, C.POST_DELETE, C.VIEWCNT, C.EDIT_DATE, C.TITLE, C.CONTENT,J.NAME FROM COMMUNITY C JOIN JOIN J ON J.NUM = C.NUM2 WHERE C.POST_DELETE = 'N' ORDER BY WRITE_DATE,POSTNUM";

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<BoardVo> BoardVoList = new ArrayList<BoardVo>();

			try {
				// SQL 담을 객체 준비
				pstmt = conn.prepareStatement(sql);

				// SQL 실행 및 결과 저장
				rs = pstmt.executeQuery();

				while (rs.next()) {
					int no = rs.getInt("POSTNUM");
					String title = rs.getString("TITLE");
					Timestamp editDate = rs.getTimestamp("EDIT_DATE");
					String name = rs.getString("NAME");
					String content = rs.getString("CONTENT");

					BoardVo vo = new BoardVo();
					vo.setPostNum(no);
					vo.setTitle(title);
					vo.setWriteDate(editDate);
					vo.setName(name);
					vo.setContent(content);
					
					BoardVoList.add(vo);

				}

			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}

			// SQL 실행 결과 리턴

			return BoardVoList;
		}
}
