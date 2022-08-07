package com.umpaumpa.swim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;

public class SwimDao {
	
public List<SwimVo> searchSf() {
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<SwimVo> swimVoList = new ArrayList<SwimVo>();
		try {
			conn = JDBCTemplate.getConnection();
			String sql="SELECT * FROM STROKE_INFO ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				String strokeNo = rs.getString("STROKE_NO");
				String sName = rs.getString("S_NAME");
				int sKcal = rs.getInt("S_KCAL");
				String description = rs.getString("DESCRIPTION");
				
				SwimVo vo = new SwimVo();
				vo.setStrokeNo(strokeNo);
				vo.setsName(sName);
				vo.setsKcal(sKcal);
				vo.setDescription(description);
				
				swimVoList.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return swimVoList;
		
	}

public int insertFs(SwimVo vo) {
	
	Connection conn = null;
	PreparedStatement pstmt = null; 
	int result = 0;
	
	try {
		conn = JDBCTemplate.getConnection();
		String sql="INSERT INTO STROKE_INFO(STROKE_NO,S_NAME,S_KCAL,DESCRIPTION) VALUES (?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,vo.getStrokeNo());
		pstmt.setString(2,vo.getsName());
		pstmt.setInt(3,vo.getsKcal());
		pstmt.setString(4,vo.getDescription());
		
		result = pstmt.executeUpdate();
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
	} catch (Exception e) {
		JDBCTemplate.rollback(conn);
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
	}
	
	return result;
	
	
}

public SwimVo searchSfInfoDe(String strokeNo) {
	
	Connection conn = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	SwimVo vo = null;
	try {
		conn = JDBCTemplate.getConnection();
		String sql="SELECT * FROM STROKE_INFO WHERE STROKE_NO = ? ";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, strokeNo);
		
		rs = pstmt.executeQuery();
		
		
		if(rs.next()) {
			String strokeNum = rs.getString("STROKE_NO");
			String sName = rs.getString("S_NAME");
			int sKcal = rs.getInt("S_KCAL");
			String description = rs.getString("DESCRIPTION");
			
			vo = new SwimVo();
			vo.setStrokeNo(strokeNum);
			vo.setsName(sName);
			vo.setsKcal(sKcal);
			vo.setDescription(description);
			
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
	}
	
	
	
	return vo;
}

public int updateSf(String sNo, String description) {
	Connection conn = null;
	PreparedStatement pstmt = null; 
	int result = 0;
	
	try {
		conn = JDBCTemplate.getConnection();
		String sql="UPDATE STROKE_INFO SET DESCRIPTION = ? WHERE STROKE_NO = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,description);
		pstmt.setString(2,sNo);
		
		
		result = pstmt.executeUpdate();
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
	} catch (Exception e) {
		JDBCTemplate.rollback(conn);
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
	}
	
	return result;
}

public int deleteSf(String sNo) {
	Connection conn = null;
	PreparedStatement pstmt = null; 
	int result = 0;
	
	try {
		conn = JDBCTemplate.getConnection();
		String sql="DELETE FROM STROKE_INFO WHERE STROKE_NO = ?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,sNo);
		
		
		result = pstmt.executeUpdate();
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
	} catch (Exception e) {
		JDBCTemplate.rollback(conn);
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
	}
	
	return result;
}
}
