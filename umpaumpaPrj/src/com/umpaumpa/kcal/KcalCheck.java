package com.umpaumpa.kcal;

import java.awt.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.umpaumpa.common.JDBCTemplate;
import com.umpaumpa.main.Main;
import com.umpaumpa.member.MemberVo;

public class KcalCheck {
	static Scanner sc = new Scanner(System.in);
	
public static void Calla(MemberVo data) {
		
		System.out.println("영법을 선택해주세요.\n1. 자유영(저속)\n2. 자유영(중속)\n3. 자유영(강속)\n4. 배영\n5. 평영\n6. 선헤엄\n7. 접영");
		System.out.print(">>해당번호를 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.println("운동 시간을 분단위로 입력해주세요");
		System.out.print(">>운동시간을 입력해주세요(단위:분) : ");
		int min = sc.nextInt();
		
		double weight = data.getWeight();
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
		
		System.out.println("오늘의 소모 칼로리는 "+Kresult+"입니다.");
		
		new KcalCheck().saveKcal(Kresult, min);
	}

public int saveKcal(double Kresult, int min){
	
	System.out.println("해당 기록을 저장하시겠습니까? Y / N ");
	System.out.println(">> Y 또는 N을 입력해주세요 : ");
	String input = sc.nextLine();
	
	int result = 0;
	
	if(input.equals("Y")) {
		//Kresult, min ,date를 ?,?,SYSDATE로 db에 저장하기
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			String sql = "INSERT INTO RECORD(KCAL, MIN, DATE) VALUES(?,?,SYSDATE)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1,Kresult);
			pstmt.setInt(2,min);
			
			result = pstmt.executeUpdate();
			
			if(result ==1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			JDBCTemplate.rollback(conn);
		}
		finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		
	}else {
		System.out.println("이전 화면으로 돌아갑니다.");//main화면으로
		//+++++++++++이부분+++++++++++++//
//		return;
		
	}
	
	return result;
	//리턴이 if문 안쪽에 있어서 문제에요 ~
	// 만약 if 를 통과하지 못한다면, 리턴되는값이 없으니 에러가 발생해요 ~아하
	//해결한번 해보시겠어요 ? ㅎㅎ
	// 한 30분 곰니해도 안되면 다시 들고와주세요 ~ !
	
}//saveKcal

public static void CheckKcal() {
	Scanner sc = new Scanner(System.in);
	System.out.println("조회를 원하는 날짜를 입력해주세요.(예 : 220725)");
	System.out.println(">> 날짜를 입력해주세요 : ");
	String date = sc.nextLine();
	String no = Main.loginMember.getNo();
	
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 int result =0;
	 double Kresult = 0;
	 
	try {
		conn = JDBCTemplate.getConnection();
		String sql = "SELECT KCAL FROM RECORD WHERE SWIMDATE >= ? AND SWIMDATE < ? AND NUM = ?";
		//++++++++++++++로그인한 아이디의 기록만 조회가 되도록해야함. 어떤걸로 중복 체크해야하는지??
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,date);
		pstmt.setString(2,date);
		pstmt.setString(3,no);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {//칼럼 이름을 가르키는 스키마 다음줄을 알고싶기 떄문에 넥스트!!!
			Kresult = rs.getDouble("KCAL");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
	}
	
	System.out.println(date+"의 소모칼로리는"+Kresult+"입니다.");
	
	}//CheckKcal

public void checkRe() {
	int num = new KcalMenu().checkReturn();
	
	if(num == 1) {
		System.out.println("메인메뉴로 돌아갑니다");
		return;
	}else if(num == 2) {
		//++++++++++++++++++++프로그램 종료+++++
		return;//?
		
	}
}

}
