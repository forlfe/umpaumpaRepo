package com.umpaumpa.kcal;

import java.sql.Connection;
import java.util.Scanner;

import com.umpaumpa.main.Main;
import com.umpaumpa.member.MemberVo;

public class KcalController {
	
	public static MemberVo loginMember;
	static Scanner sc = new Scanner(System.in);  
	
	public void Calla() throws Exception {
		
		if(Main.loginMember != null) {
			System.out.println(Main.loginMember.getNick()+"님 환영합니다.");
		}
		
		System.out.println("오늘 소모한 칼로리를 계산합니다.");
		System.out.println("영법을 선택해주세요.\n1. 자유영(저속)\n2. 자유영(중속)\n3. 자유영(강속)\n4. 배영\n5. 평영\n6. 선헤엄\n7. 접영");
		System.out.print(">>해당번호를 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.println("운동 시간을 분단위로 입력해주세요");
		System.out.print(">>운동시간을 입력해주세요(단위:분) : ");
		int min = sc.nextInt();
		sc.nextLine();
		
		double weight =  Main.loginMember.getWeight();
		double Kresult = 0;
		if(num==1) {
			Kresult  = (weight*0.089)*min; 
		}else if(num==2) {
			Kresult  =(weight*0.138)*min; 
		}else if(num==3) {
			Kresult  =(weight*0.163)*min; 
		}else if(num==4) {
			Kresult  =(weight*0.08)*min; 
		}else if(num==5) {
			Kresult  =(weight*0.088)*min; 
		}else if(num==6) {
			Kresult  =(weight*0.058)*min;
		}else if(num==7) {
			Kresult  =(weight*0.23)*min; 
		}else {
			System.out.println("숫자를 다시 입력해주세요."); return;
		}
		System.out.println("");
		System.out.println(">>>>>오늘의 소모 칼로리는 "+Kresult+"입니다.<<<<<");
		System.out.println("");
		System.out.println("해당 기록을 저장하시겠습니까? Y / N ");
		System.out.print(">> Y 또는 N을 입력해주세요 : ");
		String input = sc.nextLine();
		
		int result = new KcalService().Calla(Kresult, min,input,num);
		
		if(result == 1) {
			System.out.println("---------------------------");
			System.out.println("| 저장 성공 ! 메인으로 돌아갑니다.   ");
			System.out.println("---------------------------");
		}else {
			System.out.println("[ERROR :"+result+"] 저장 실패 ...");
		}
		
	}//Calla
	
	
}//class
