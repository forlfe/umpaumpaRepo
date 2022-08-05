package com.umpaumpa.record;

import java.sql.Timestamp;
import java.util.List;

import com.umpaumpa.main.Main;
import com.umpaumpa.util.Inpututil;

public class RecordController {

	public static void showList() {
		
		List<RecordVo> recordVoList = new RecordService().showList();
		RecordVo temp = null;
		
		
		System.out.println("------- 기록을 확인합니다 ------- \n");
		
		//로그인 체크
				if(Main.loginMember == null) {
					System.out.println("로그인을 먼저 해주세요");
					return;//다음 진행하면 안 되니까 return
				}
		
	//	if(Main.loginMember.getNo() == RecordVo.setNum(num)) {
	
			for(int i = 0; i <recordVoList.size(); ++i) {
				
			temp = recordVoList.get(i);
			
					
			int no = temp.getNumrec();
			String nick = temp.getNick();
			Timestamp swimDate = temp.getSwimDate();
			
			int strokeNo = temp.getStrokeNo();
			int min = temp.getMin();
			int num = temp.getNum();
			double kcal = temp.getKcal();
			String sNmame = temp.getsName();
			
			//System.out.println("기록번호 | 닉네임 | 날짜 | 영법번호 | 시간 | 소모칼로리");
			//System.out.println(no + " | "+ nick+ " | " + date + " | " + strokeNo +" | " + min +" | " + kcal);
			//if(num = RecordVo.setNum()) {
			System.out.println("기록번호: " + no + "| 닉네임: " + nick + "| 날짜: "+ swimDate + /*"| 영법: " + sName + */"| 시간(분): " + min + "| 소모칼로리: " + kcal +"kcal" );
			
			
			}
	}//showList
	
	
	

}
	

	
	

