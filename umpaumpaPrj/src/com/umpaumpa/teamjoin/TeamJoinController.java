package com.umpaumpa.teamjoin;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.umpaumpa.main.Main;
import com.umpaumpa.member.MemberVo;
import com.umpaumpa.team.TeamVo;

public class TeamJoinController {

	Scanner sc = new Scanner(System.in);

	public void join() {
		
		if(Main.loginMember != null) {
			
			System.out.println("----- 팀 리스트 -----");
			new TeamJoinController().teamShow();
			System.out.print("가입하고싶은 팀번호 : ");
			int teamCode = sc.nextInt();
			
			TeamJoinVo vo = new TeamJoinVo();
			vo.setTeamCode(teamCode);
			
			System.out.println();
			int result = new TeamJoinService().join(vo);
		}else {
			System.out.println("로그인 먼저해주세요!");
			return;
		
		
	}
	}

	public void teamShow() {

		List<TeamVo> teamVoList = new TeamJoinService().teamShow();

		for (int i = 0; i < teamVoList.size(); ++i) {
			TeamVo temp = teamVoList.get(i);

			int code = temp.getCode();
			String teamName = temp.getTeamName();
			Timestamp enrollDate = temp.getTenrollDate();

			System.out.println(code + " | " + teamName + "| 팀 생성날짜 : " + enrollDate);

		}

	}


}
