package com.umpaumpa.record;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.umpaumpa.common.JDBCTemplate;
import com.umpaumpa.main.Main;
import com.umpaumpa.menu.Menu;
import com.umpaumpa.record.RecordDao;
import com.umpaumpa.record.RecordVo;
import com.umpaumpa.util.Inpututil;

public class RecordController {

	public static void showList() {
		
		List<RecordVo> recordVoList = new RecordService().showList();
		RecordVo temp = null;
		
		
		System.out.println("운동 기록 확인 중입니다. 잠시만 기다려주세요.. \n");
		
		//로그인 체크
			if(Main.loginMember == null) {
				System.out.println("로그인을 먼저 해주세요.");
				return;
			}
		
				
			RecordVo vo = new RecordVo();

			System.out.println("::::  " + Main.loginMember.getNick() + " 님의 기록입니다.  :::: \n");
			
			for(int i = 0; i <recordVoList.size(); ++i) {
				temp = recordVoList.get(i);
				String nuum = Integer.toString(temp.getNum());
				
				if(Main.loginMember.getNo().equals(nuum)) {
			
						
					int no = temp.getNumrec();
					String nick = temp.getNick();
					Timestamp swimDate = temp.getSwimDate();
					
					int strokeNo = temp.getStrokeNo();
					int min = temp.getMin();
					int num = temp.getNum();
					double kcal = temp.getKcal();
					String sName = temp.getsName();
				
					System.out.println("기록번호: " + no + "| 닉네임: " + nick + "| 날짜: "+ swimDate +  "| 시간(분): " + min );
				
				
				}
			}
	//}//showList
	
	//상세조회 할건지 물어보기
			//출력문, S입력받기
			int num = new Menu().showRecordDetailMenu();
			
			
			//0번 입력받으면?-> 메인메뉴로 // return
			if(num == 0) {
				System.out.println("메인으로 돌아갑니다.");
				return;
			} 
			
			//글 번호 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
			RecordVo vo1 = new RecordService().showDetailByNo(num);
			
			//실행결과(게시글 객체) 화면에 보여주기
			System.out.println("\n::::: 운동기록 상세조회 :::::");
			System.out.print("기록번호 : " + vo1.getNumrec() + " | ");
			System.out.print("회원 닉네임 : " + vo1.getNick() );
			System.out.println();//줄바꿈
			System.out.println("운동일자 : " + vo1.getSwimDate());
			System.out.println("운동시간(분) : " + vo1.getMin());
			System.out.println("소모칼로리 : " + vo1.getKcal() + " kcal");
			System.out.println("영법 : " + vo1.getsName());
			
		
		}//method
	
	}
	


	

	
	

