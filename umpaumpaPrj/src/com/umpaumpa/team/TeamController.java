package com.umpaumpa.team;

import com.umpaumpa.util.Inpututil;

public class TeamController {
	
	public static void teamRank() {
		
		System.out.println("---- 나의 팀 순위 보기 ----");
		System.out.println("1. 포세이돈");
		System.out.println("2. 전현무");
		System.out.println("3. 네레우스");
		
		System.out.println();
		System.out.print("보기 중 나의 팀 번호를 입력해주세요 : ");
		int i = Inpututil.sc.nextInt();
		
		System.out.println("입력하신 번호가 맞습니까? => " + i);
		System.out.print("Y / N : ");
		String s1 = Inpututil.sc.nextLine();
		
		if(s1.equals("Y")) {
			System.out.println("=== 나의 팀 순위는 ===");
			System.out.println("-------------------");
			
			TeamDao td = new TeamDao();
			
			
			
			//레코드에서 
		}else {
			System.out.print("다시 번호를 입력해주세요 : ");
			String s2 = Inpututil.sc.nextLine();
		}
		return;
		
	}

}
