package com.umpaumpa.main;

import java.util.Scanner;

import com.umpaumpa.kcal.KcalController;
import com.umpaumpa.member.MemberController;
import com.umpaumpa.member.MemberVo;
import com.umpaumpa.menu.Menu;
import com.umpaumpa.record.RecordController;
import com.umpaumpa.team.TeamController;
import com.umpaumpa.teamjoin.TeamJoinController;

public class Main {
	
	public static MemberVo loginMember;

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣾⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣾⣿⣿⣿⣿⣿⣿⡿⠟⠻⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⢀⣴⣾⣽⣿⣶⣤⡀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀⠹⣿⣿⣿⣿⣷⡀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⢠⣶⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⣹⣿⣿⣿⣿⣿⡄⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣆⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠙⠻⢿⣿⣿⠿⠟⠁⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⢿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀⠉⠻⣿⣿⣿⡿⠋⠁⠀⠀⠀⠀⠉⠂⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣴⣶⣾⣿⣶⣦⡀⠈⠙⠛⠉⠀⣀⣤⣶⣶⣶⣶⣦⣀⠀⠙⠉⠀⣠⣶⣿⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⣤⣾⣿⣿⣿⡿⠿⠿⣿⣿⣿⣶⣤⣤⣴⣾⣿⣿⣿⠿⠿⣿⣿⣿⣷⣤⣴⣾⣿⣿⡿⠛⠿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠘⣿⣿⠟⠋⠁⠀⠀⠀⠈⠛⠿⣿⣿⣿⣿⡿⠟⠋⠁⠀⠀⠀⠙⠿⣿⣿⣿⣿⠟⠉⠀⠀⠀⠀⠙⢿⣿⣿⠇⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣶⣤⣄⠀⠀⠈⠉⠀⠀⠀⣀⣤⣤⣤⣤⣀⠀⠀⠈⠁⠀⢀⣤⣶⣶⣶⣤⣄⠀⠈⠁⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⣀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣷⣤⣀⣀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣦⣀⣠⣴⣿⣿⣿⡿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠰⣿⣿⣿⠟⠋⠁⠀⠀⠙⠿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀⠉⠻⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠉⠻⣿⣿⣿⡆⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠋⠉⠀⠀⠀⠀⠀⠀⠀⠈⠙⠋⠁⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀     ⠀안녕하세요+++음파음파+++입니다⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀원하시는 번호를 선택해주세요.⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		Menu menu = new Menu();
		while(true) {
			//메뉴 보여주기
			int input = menu.showMenu();
			
			//선택한 값에 따라 동작
			switch(input) {
			case 1:
				new MemberController().login(); 
				break;
			case 2: 
				new MemberController().join(); 
				break;
			case 3:
				new RecordController().showList();
				break;
			case 4: 
				new KcalController().Calla(); 
				break;
			case 5: 
				new TeamJoinController().join();
				break;
			case 6: 
				new TeamController().teamRank(); 
				break;
			case 7: 
				new MemberController().community();
				break;
			case 8: 
				new MemberController().myPage(); 
				break;
			case 9: 
				new MemberController().adminPage();
				break;
			case 0: 
				//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}//switch
			
		}

	}

}
