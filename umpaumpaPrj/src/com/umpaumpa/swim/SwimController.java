package com.umpaumpa.swim;

import java.util.List;

import com.umpaumpa.util.Inpututil;

public class SwimController {
	
public void searchSfInfo() {
		
		System.out.println("전체 영법 정보를 조회합니다.");
			
		List<SwimVo> swimVoList = new SwimDao().searchSf();
		
		System.out.println("------------- 영 법 정 보------------");
		System.out.println("===================================");
		
		for(int i =0; i<swimVoList.size(); i++) {
			
			SwimVo temp = swimVoList.get(i);
			
			String strokeNo = temp.getStrokeNo();
			String sName = temp.getsName();
			int sKcal = temp.getsKcal();
			String description = temp.getDescription();
			
			
			
			System.out.println(strokeNo+" | "+sName+" | "+sKcal+" | "+description);
			
		}
			
		
		
		
	}

	public void searchSfInfoDe() {
		
		System.out.println("상세 영법 정보를 조회합니다.");
		System.out.println("영법 번호를 입력하여 주십시오.: ");
		String strokeNo = Inpututil.sc.nextLine();
		
		SwimVo vo = new SwimDao().searchSfInfoDe(strokeNo);
		
		System.out.println("------------- 영 법 정 보------------");
		System.out.println("===================================");
		System.out.print("영법번호: "+ vo.getStrokeNo()+" | ");
		System.out.print("영법: "+vo.getsName()+" | ");
		System.out.print("소모칼로리: "+vo.getsKcal());
		System.out.println();
		System.out.println("내용: "+vo.getDescription());
		
	}

public void insertSf() {
		
		System.out.println("추가하실 영법의 번호를 입력하세요.: ");
		String sNo = Inpututil.sc.nextLine();
		System.out.println("추가하실 영법을 입력하세요.: ");
		String sName = Inpututil.sc.nextLine();
		System.out.println("추가하실 영법의 칼로리를 입력하세요.: ");
		int sKcal = Inpututil.getint();
		System.out.println("영법 묘사를 기재해 주세요.: ");
		String description= Inpututil.sc.nextLine();
		
		
		SwimDao sd = new SwimDao();
		SwimVo vo = new SwimVo();
		vo.setStrokeNo(sNo);
		vo.setsName(sName);
		vo.setsKcal(sKcal);
		vo.setDescription(description);
		
		int result = sd.insertFs(vo);
		
		if(result == 1) {
			System.out.println("영법 추가 완료하였습니다.");
			System.out.println("=====================================");
			System.out.println();
		}else {
			System.out.println("[ERROR: " +result+ "} 추가에 실패하였습니다!");
		}
		
		
		
	}

	public void updateSf() {
		
		
		System.out.println("수정하실 영법의 번호를 입력하세요.: ");
		String sNo = Inpututil.sc.nextLine();
		System.out.println("영법 묘사 수정본을 기재해 주세요.: ");
		String description= Inpututil.sc.nextLine();
		
		
		SwimDao sd = new SwimDao();
		SwimVo vo = new SwimVo();
		vo.setStrokeNo(sNo);
		vo.setDescription(description);
		int result = sd.updateSf(sNo, description);
		
		if(result == 1) {
			System.out.println("영법 수정 완료하였습니다.");
			System.out.println("==========================================");
			System.out.println();
		}else {
			System.out.println("[ERROR: " +result+ "} 수정에 실패하였습니다!");
		}
		
		
		
		
	}

	public void deleteSf() {
		
		System.out.println("삭제하실 영법의 번호를 입력하세요.: ");
		String sNo = Inpututil.sc.nextLine();
		
		
		SwimDao sd = new SwimDao();
		SwimVo vo = new SwimVo();
		vo.setsName(sNo);
		
		int result = sd.deleteSf(sNo);
		
		if(result == 1) {
			System.out.println("영법 삭제 완료하였습니다.");
			System.out.println("=======================================");
			System.out.println();
		}else {
			System.out.println("[ERROR: " +result+ "} 삭제에 실패하였습니다!");
		}
		
		
	}

}
