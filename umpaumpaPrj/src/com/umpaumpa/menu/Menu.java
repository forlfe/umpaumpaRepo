package com.umpaumpa.menu;

import com.umpaumpa.main.Main;
import com.umpaumpa.util.Inpututil;

public class Menu {
	
public int showMenu() {
		
		System.out.println("\n\n------ 메인메뉴 ------");
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

}
