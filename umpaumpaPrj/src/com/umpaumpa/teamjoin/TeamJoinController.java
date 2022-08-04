package com.umpaumpa.teamjoin;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.umpaumpa.member.MemberVo;
import com.umpaumpa.team.TeamVo;


public class TeamJoinController {
	
	Scanner sc = new Scanner(System.in);

	public void join() {
		
		System.out.println("----- 팀 리스트 -----");
		
		new TeamJoinController().teamShow();
		
		System.out.print("가입하려는 팀 번호: ");
		int teamCode = sc.nextInt();
		
		TeamJoinVo vo = new TeamJoinVo();
		vo.setTeamCode(teamCode);
		
		int result = new TeamJoinService().join(vo);
		
		if(result == 1) {
			System.out.println("팀 가입 성공 !");
			new TeamJoinController().joinTeamShow();
		}else {
			System.out.println("[ERROR:" + result + "] 팀가입 실패 ...");
		}
		
	}
	public void joinTeamShow() {
		
		List<TeamVo> teamVoList = new TeamJoinService().teamShow();
		
		for(int i = 0 ; i < teamVoList.size(); ++i) {
			TeamVo temp = teamVoList.get(i);
			
			int code = temp.getCode();
			String teamName = temp.getTeamName();

			
			System.out.println(" 가입한팀 : "+ teamName+" 팀코드 : "+code);
		}
	}
	
	public void teamShow() {
		
		List<TeamVo> teamVoList = new TeamJoinService().teamShow();
		
		for(int i = 0 ; i < teamVoList.size(); ++i) {
			TeamVo temp = teamVoList.get(i);
			
			int code = temp.getCode();
			String teamName = temp.getTeamName();
			Timestamp enrollDate = temp.getTenrollDate();
			
			System.out.println(code+ " | " + teamName + "| 팀 생성날짜 : " + enrollDate);
			
		}
		
	
	}

}
