package com.umpaumpa.menu;

import com.umpaumpa.main.Main;
import com.umpaumpa.member.MemberController;
import com.umpaumpa.swim.SwimController;
import com.umpaumpa.team.TeamController;
import com.umpaumpa.util.Inpututil;

public class Menu {
	
public int showMenu() {
		
		System.out.println("\n\n------ 메인메뉴 ------");
		
		System.out.println("원하시는 기능의 번호를 입력해주세요.");
		System.out.print(">> 해당 번호 입력 : ");
		System.out.println("");
		
		if(Main.loginMember != null) {
			//로그인 O
			System.out.println(Main.loginMember.getNick()+"님 환영합니다.");
			System.out.println("3.나의 운동기록");
			System.out.println("4.소모칼로리 조회");
			System.out.println("5.팀가입하기");
			System.out.println("6.팀활동");
			System.out.println("7.자유게시판");
			System.out.println("8.마이페이지");
			System.out.println("9.관리자페이지");
		}else {
			//로그인X
			System.out.println("1.로그인");
			System.out.println("2.회원가입");
			System.out.println("3.나의 운동기록");
			System.out.println("4.소모칼로리 조회");
			System.out.println("5.팀가입하기");
			System.out.println("6.팀활동");
			System.out.println("7.자유게시판");
			System.out.println("8.마이페이지");
			System.out.println("9.관리자페이지");
			
		}
		
		System.out.println("0. 프로그램 종료");
		
		return Inpututil.getint();
	}//method

	public int showAdminMenu() {
	
	if(Main.loginMember != null) {
		System.out.println(Main.loginMember.getAdminId()+" 님 안녕하세요.");
		System.out.println("==========================================");
		System.out.println("1. 회원 관리");
		System.out.println("2. 영법 관리");
		System.out.println("3. 팀 관리");
		
		
	}else {
		System.out.println("===========================================");
		System.out.println("1. 회원 관리");
		System.out.println("2. 영법 관리");
		System.out.println("3. 팀 관리");
		
	}
	
	return Inpututil.getint();
	
}
	public void memberSearchMenu() {
	
	System.out.println("   회 원 관 리  ");
	System.out.println("==============");
	System.out.println("1. 전체 회원 조회");
	System.out.println("2. 특정 회원 조회");
	
	MemberController mc = new MemberController();
	
	int a = Inpututil.getint();
	if(a == 1) {
		mc.memberSearch();
	}else if(a == 2) {
		mc.memberSearchDe();
	}else {
		System.out.println("다시 선택하여 주십시오.");
		return;
	}
	
	
}

	public void swimAdminMenu() {
	System.out.println("   영 법 관 리  ");
	System.out.println("==============");
	System.out.println("1. 전체 영법조회");
	System.out.println("2. 특정 영법조회");
	System.out.println("3. 영법 추가하기");
	System.out.println("4. 영법 수정하기");
	System.out.println("5. 영법 삭제하기");
	
	
	SwimController sc = new SwimController();
	
	int a = Inpututil.getint();
	if(a == 1) {
		sc.searchSfInfo();
	}else if(a == 2) {
		sc.searchSfInfoDe();
	}else if(a == 3) {
		sc.insertSf();
	}else if(a == 4) {
		sc.updateSf();
	}else if(a == 5) {
		sc.deleteSf();
	}else {
		System.out.println("번호를 잘못 선택하였습니다. 다시 선택하여 주십시오.");
		return;
	}
	
}

	public void teamAdminMenu() {
	System.out.println("   팀 관 리  ");
	System.out.println("==============");
	System.out.println("1. 전체 팀 조회");
	System.out.println("2. 특정 팀 조회");
	System.out.println("3. 팀 추가하기");
	System.out.println("4. 팀 수정하기");
	System.out.println("2. 팀 삭제하기");
	
	TeamController tc = new TeamController();
	
	int a = Inpututil.getint();
	if(a == 1) {
		tc.searchTeamInfo();
	}else if(a == 2) {
		tc.searchTeamInfoDe();
	}else if(a == 3) {
		tc.insertTeam();
	}else if(a == 4) {
		tc.updateTeam();
	}else if(a == 5) {
		tc.deleteTeam();
	}else {
		System.out.println("번호를 잘못 선택하였습니다. 다시 선택하여 주십시오.");
		return;
	}
	
}

}
