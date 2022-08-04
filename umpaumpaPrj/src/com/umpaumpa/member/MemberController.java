package com.umpaumpa.member;

import java.sql.Connection;

import com.umpaumpa.common.JDBCTemplate;
import com.umpaumpa.main.Main;
import com.umpaumpa.util.Inpututil;

public class MemberController {
	
	public void login() {
//		if(Main.loginmember!=null) {
//			System.out.println("이미 로그인하셨습니다.");
//			return;
//		}												//로그인 시 로그인 화면 재진입 막음
		System.out.println("로그인~~~");
		MemberVo imfor=null;
		
		System.out.println("아이디 : ");
		String id = Inpututil.sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = Inpututil.sc.nextLine();
		try {
			MemberVo vo = MemberDao.login(id, pwd);
			imfor=MemberDao.login(id, pwd);
			if(vo!=null) {
				System.out.println("로그인 성공!");
				//Main.loginmember=imfor;				//로그인 시 해당 정보를 메인으로 전송
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("로그인 에러!");
			//e.printStackTrace();
		}
	}
	
	public void join() {
		System.out.println("회원가입~~~");
		
		
		System.out.println("아이디 :");
		String id = Inpututil.sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = Inpututil.sc.nextLine();
		System.out.println("비밀번호 확인 : ");
		String pwd2 = Inpututil.sc.nextLine();
		System.out.println("이름 :");
		String name = Inpututil.sc.nextLine();
		System.out.println("닉네임 : ");
		String nick = Inpututil.sc.nextLine();
		System.out.println("몸무게 :");
		double weight = Inpututil.sc.nextInt();
		System.out.println("성별 : ");
		String gender = Inpututil.sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setPwd2(pwd2);
		vo.setName(name);
		vo.setNick(nick);
		vo.setWeight(weight);
		vo.setGender(gender);
		
		Connection conn = null;
		int result=0;
		
		result = MemberService.join(vo, conn);
		
		
		if(result==1) {
			System.out.println("회원가입 성공~");
		} else {
			System.out.println("회원가입 실패");
		}
	}

}
