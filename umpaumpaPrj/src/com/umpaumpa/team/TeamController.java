package com.umpaumpa.team;

import java.sql.Timestamp;
import java.util.List;

import com.umpaumpa.teamjoin.TeamJoinVo;
import com.umpaumpa.util.Inpututil;

public class TeamController {
	
	public static int teamRank() {
		
		//팀 보기 번호 출력
		System.out.println("------- 나의 팀 순위 보기 -------");
		System.out.println("==============================");
		System.out.println("아래 보기 중 나의 팀 번호를 입력해주세요:D ");
		System.out.println("1. 포세이돈");
		System.out.println("2. 전현무");
		System.out.println("3. 네레우스");
		System.out.println();
		
		//팀 번호 입력 받기
		System.out.print("나의 팀 번호 : ");
		int i = Inpututil.sc.nextInt();
		
		//팀 번호 재확인 받기
		
		if(i == 1) {
			System.out.println("입력하신 번호가 맞습니까? => " + i + ". 포세이돈");
			System.out.print("Y / N : ");
			String s1 = Inpututil.sc.nextLine();
			
			if(s1.equals("Y")) {
				System.out.println("=== 나의 팀 순위는 ===");
				//1. 포세이돈 팀 순위 출력
//				new TeamDao().teamRank();
			}
		}else if(i == 2) {
			System.out.println("입력하신 번호가 맞습니까? => " + i + ". 전현무");
			System.out.print("Y / N : ");
			String s1 = Inpututil.sc.nextLine();
			
			if(s1.equals("Y")) {
				System.out.println("=== 나의 팀 순위는 ===");
				//2. 전현무 팀 순위 출력
				
			}
		}else if(i ==3) {
			System.out.println("입력하신 번호가 맞습니까? => " + i + ". 네레우스");
			System.out.print("Y / N : ");
			String s1 = Inpututil.sc.nextLine();
			
			if(s1.equals("Y")) {
				System.out.println("=== 나의 팀 순위는 ===");
				//3. 네레우스 팀 순위 출력
				
			}
		}else {
			System.out.println("잘못 입력하였습니다ㅠ");
		}
		
		return i;
		
	}
	public void searchTeamInfo() {
		System.out.println("전체 팀 정보를 조회합니다.");
		
		List<TeamVo> teamVoList = new TeamDao().searchTeamInfo();
		
		System.out.println("------------- 팀 정 보------------");
		System.out.println("===================================");
		
		for(int i =0; i<teamVoList.size(); i++) {
			
			TeamVo temp = teamVoList.get(i);
			
			int code = temp.getCode();
			int num = temp.getCap();
			String teamName = temp.getTeamName();
			Timestamp tenrollDate = temp.getTenrollDate();
			int record = temp.getRecord();
			
			
			
			System.out.println(code+" | "+num+" | "+teamName+" | "+tenrollDate+" | "+record);
			
		}
			
		
	}

	public void searchTeamInfoDe() {
		
		System.out.println("상세 팀 정보를 조회합니다.");
		System.out.println("팀 번호를 입력하여 주십시오.: ");
		int code = Inpututil.getint();
		
		TeamVo vo = new TeamDao().searchTeamInfoDe(code);
		
		System.out.println("------------- 팀 정 보------------");
		System.out.println("===================================");
		System.out.print("팀코드: "+ vo.getCode()+" | ");
		System.out.print("팀이름: "+vo.getTeamName()+" | ");
		System.out.print("팀생성날짜: "+vo.getTenrollDate()+" | ");
		System.out.println("최고기록: "+vo.getRecord());
		
		
	}

	public void insertTeam() {
		
		System.out.println("팀장 번호를 입력하세요.: ");
		int capNo = Inpututil.getint();
		
		System.out.println("추가하실 팀이름을 입력하세요.: ");
		String newTeamName = Inpututil.sc.nextLine();
		
		
		
		TeamDao sd = new TeamDao();
		TeamVo vo = new TeamVo();
		vo.setCap(capNo);
		vo.setTeamName(newTeamName);
		
		int result = sd.insertTeam(capNo, newTeamName);
		
		if(result == 1) {
			System.out.println("팀 추가 완료하였습니다.");
			System.out.println("======================================");
			System.out.println();
		}else {
			System.out.println("[ERROR: " +result+ "} 추가에 실패하였습니다!");
		}
		
		
	}

	public void updateTeam() {
		
		System.out.println("수정하실 현재 팀번호를 입력하세요.: ");
		int code = Inpututil.getint();
		System.out.println("수정할 새로운 팀이름을 입력하세요.: ");
		String newTeamName= Inpututil.sc.nextLine();
		
		
		TeamDao sd = new TeamDao();
		TeamVo vo = new TeamVo();
		vo.setCode(code);
		vo.setTeamName(newTeamName);
		int result = sd.updateTeam(code,newTeamName);
		
		if(result == 1) {
			System.out.println("팀이름 수정을 완료하였습니다.");
			System.out.println("======================================");
			System.out.println();
		}else {
			System.out.println("[ERROR: " +result+ "} 수정에 실패하였습니다!");
		}
		
		
	}

	public void deleteTeam() {
		
		System.out.println("삭제할 팀번호를 입력하세요.: ");
		int teamCode = Inpututil.getint();
		
		
		TeamDao sd = new TeamDao();
		TeamVo vo = new TeamVo();
		vo.setCode(teamCode);
		
		int result = sd.deleteTeam(teamCode);
		
		if(result == 1) {
			System.out.println("팀 삭제 완료하였습니다.");
			System.out.println("=======================================");
			System.out.println();
		}else {
			System.out.println("[ERROR: " +result+ "} 삭제에 실패하였습니다!");
		}
		
		
		
	}
	
	

}
