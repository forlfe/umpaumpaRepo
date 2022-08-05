package com.umpaumpa.member;

import java.sql.Connection;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;

public class MemberService {

	public static int join(MemberVo vo, Connection conn) {
		// TODO Auto-generated method stub

		int result = 0;

		// id check(id<4)
		int idcheck = vo.getId().length();

		if (idcheck < 4) {

			System.out.println("아이디 수가 너무 적습니다.");
			return -1;
		}
		// pwd > 4
		int pwdcheck1 = vo.getPwd().length();
		if (pwdcheck1 < 4) {
			System.out.println("비밀번호 수가 너무 적습니다.");
			return -2;
		}
		// pwd1==pwd2
		if (vo.getPwd().equals(vo.getPwd2()) == false) {
			System.out.println("비밀번호가 서로 일치하지 않습니다.");
			return -3;
		}

		try {
			conn = JDBCTemplate.getConnection();
			result = MemberDao.join(vo, conn);
			if (result == 1) {
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

	public int updatePwd(MemberVo vo) {

		String pwdCheck = new MemberController().login(vo);

		if (pwdCheck == null) {
			System.out.println("현재 비밀번호와 일치하지 않습니다.");
			return -1;
		}
		if (!vo.getPwd2().equals(vo.getPwd3())) {
			System.out.println("신규 비밀번호가 일치하지 않습니다.");
			return -2;
		}
		Connection conn = null;

		int result = 0;

		try {
			conn = JDBCTemplate.getConnection();
			result = new MemberDao().updatePwd(vo.getId(), vo.getPwd(), conn);

			if (result == 1) {
				System.out.println("비밀번호 변경을 완료하였습니다.");
				JDBCTemplate.commit(conn);
			} else {
				System.out.println("비밀번호 변경을 실패하였습니다.");
				JDBCTemplate.rollback(conn);
			}
		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);

		}
		return result;
	}

	public int updateNick(MemberVo vo) {

		String nickCheck = new MemberController().login(vo);
		if (nickCheck == null) {
			System.out.println("현재 닉네임과 일치하지 않습니다.");
			return -1;
		}
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();

			result = new MemberDao().updateNick(vo.getId(), vo.getNick2(), conn);

			if (result == 1) {
				System.out.println("닉네임 변경을 완료하였습니다.");
				JDBCTemplate.commit(conn);
			} else {
				System.out.println("닉네임 변경을 실패하였습니다.");
				JDBCTemplate.rollback(conn);
			}

		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}

		return result;
	}

	public int updateWeight(MemberVo vo) {

		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();

			result = new MemberDao().updateWeight(vo.getId(), vo.getWeight(), conn);

			if (result == 1) {
				System.out.println("몸무게 수정을 완료하였습니다.");
				JDBCTemplate.commit(conn);
			} else {
				System.out.println("몸무게 수정을 실패하였습니다.");
				JDBCTemplate.rollback(conn);
			}

		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}

		return result;
	}

	public int write(MemberVo vo) {

		if (vo.getTitle().length() < 1) {

			return -1;
		}
		if (vo.getContent().length() < 1) {

			return -2;
		}

		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = new MemberDao().write(vo, conn);

			if (result == 1) {
				JDBCTemplate.close(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}

		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}

		return result;
	}

	public List<BoardVo> showList() {
		Connection conn = null;
		List<BoardVo> boardVoList = null;
		try {
			conn = JDBCTemplate.getConnection();

			boardVoList = new MemberDao().showList(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}

		return boardVoList;

	}

}
