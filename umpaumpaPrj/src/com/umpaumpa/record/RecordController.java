package com.umpaumpa.record;

import java.sql.Timestamp;
import java.util.List;

public class RecordController {

	public static void showList() {
		
		List<RecordVo> recordVoList = new RecordService().showList();
		RecordVo temp = null;
		
		System.out.println("----- 기록을 확인합니다----- \n");
	
		for(int i = 0; i <recordVoList.size(); ++i) {
			
		temp = recordVoList.get(i);
		
				
		int no = temp.getNumrec();
		String nick = temp.getNick();
		Timestamp date = temp.getDate();
		
		int strokeNo = temp.getStrokeNo();
		int min = temp.getMin();
		int num = temp.getNum();
		double kcal = temp.getKcal();
		
		//System.out.println("기록번호 | 닉네임 | 날짜 | 영법번호 | 시간 | 소모칼로리");
		//System.out.println(no + " | "+ nick+ " | " + date + " | " + strokeNo +" | " + min +" | " + kcal);
		System.out.println("기록번호: " + no + "| 닉네임: " + nick + "| 날짜: "+ date + "| 영법번호: " + strokeNo + "|시간(분): " + min + "|소모칼로리: " + kcal +"kcal" );
		
		}
	}
	

}
	
	

