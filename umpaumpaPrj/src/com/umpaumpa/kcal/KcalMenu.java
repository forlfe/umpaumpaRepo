package com.umpaumpa.kcal;

import com.umpaumpa.main.Main;
import com.umpaumpa.util.Inpututil;

public class KcalMenu {

public int showMenu() {
		
		System.out.println("\n\n------ 메인메뉴 ------");
		if(Main.loginMember != null) {
			//로그인 O
			System.out.println(Main.loginMember.getNick()+"님 환영합니다.");
			System.out.println("1.오늘 소모 칼로리 계산");
			System.out.println("2.이전 소모 칼로리 조회");
			System.out.println("3.첫 화면으로 돌아가기");//로그인 회원가입 있는 클래스로 돌아가야함
		}
			System.out.println("9. 프로그램 종료");
		
		return Inpututil.getint();
	}//method

	public int checkReturn() {
		System.out.println("첫화면으로 돌아가시겠습니까?\n1:첫화면으로 돌아가기\n2:프로그램 종료하기");
		System.out.println(">>1또는2를 입력해주세요 : ");
		return Inpututil.getint();
	}//checkReturn
}//class
