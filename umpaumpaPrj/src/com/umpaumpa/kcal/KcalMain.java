package com.umpaumpa.kcal;

import com.umpaumpa.member.MemberVo;

public class KcalMain {

	public static MemberVo loginMember;
	
	public static void main() {

		
		KcalMenu menu = new KcalMenu();
		while(true) {
			//메뉴 보여주기
			int input = menu.showMenu();
			
			//선택한 값에 따라 동작
			switch(input) {
			case 1://오늘 소모 칼로리 확인
				//new KcalCheck().Calla(); 
				break;
			case 2: //이전 기록 조회
				new KcalCheck().CheckKcal(); 
				break;
			case 3://첫화면으로 돌아가기 //로그인 회원가입있는 페이지로 돌아가기
				return;
			case 9: 
				//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}//switch
			
		}
		
		}
	
	
	
}
