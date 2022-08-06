package com.umpaumpa.member;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.umpaumpa.common.JDBCTemplate;
import com.umpaumpa.main.Main;
import com.umpaumpa.menu.Menu;
import com.umpaumpa.util.Inpututil;

public class MemberController {

	public void login() {
		if (Main.loginMember != null) {
			System.out.println("이미 로그인하셨습니다.");
			return;
		} // 로그인 시 로그인 화면 재진입 막음
		System.out.println("로그인~~~");
		MemberVo imfor = null;

		System.out.println("아이디 : ");
		String id = Inpututil.sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = Inpututil.sc.nextLine();
		try {
			MemberVo vo = MemberDao.login(id, pwd);
			imfor = MemberDao.login(id, pwd);
			if (vo != null) {
				System.out.println("로그인 성공!");
				Main.loginMember = imfor; // 로그인 시 해당 정보를 메인으로 전송
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("로그인 에러!");
			// e.printStackTrace();
		}
	}

	public void join() {
		System.out.println("회원가입~~~");

		System.out.println("아이디 :");
		String id = Inpututil.sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = Inpututil.sc.nextLine();
		System.out.println("비밀번호 확인 : ");
		String pwd2 = Inpututil.sc.nextLine();
		System.out.println("이름 :");
		String name = Inpututil.sc.nextLine();
		System.out.println("닉네임 : ");
		String nick = Inpututil.sc.nextLine();
		System.out.println("몸무게 :");
		int weight = Inpututil.sc.nextInt();
		System.out.println("성별 : ");
		String gender = Inpututil.sc.nextLine();

		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setPwd2(pwd2);
		vo.setName(name);
		vo.setNick(nick);
		vo.setWeight(weight);
		vo.setGender(gender);

		Connection conn = null;
		int result = 0;

		result = MemberService.join(vo, conn);

		if (result == 1) {
			System.out.println("회원가입 성공~");
		} else {
			System.out.println("회원가입 실패");
		}
	}

	public void adminPage() {

		adminLogin();

		Menu menu = new Menu();

		while (true) {
			int input = menu.showAdminMenu();
			switch (input) {
			case 1:
				menu.memberSearchMenu();
				break;
			case 2:
				menu.swimAdminMenu();
				break;
			case 3:
				menu.teamAdminMenu();
				break;

			}
		}

	}

	public void adminLogin() {

		System.out.print("관리자 아이디를 입력하여 주십시오.:  ");
		String adminId = Inpututil.sc.nextLine();
		System.out.print("관리자 비밀번호를 입력하여 주십시오.: ");
		String adminPwd = Inpututil.sc.nextLine();

		try {
			MemberVo vo = new MemberDao().adminLogin(adminId, adminPwd);
			if (vo != null) {
				System.out.println("관리자 님 안녕하세요.");
				Main.loginMember = vo;
			} else {
				System.out.println("관리자 로그인 실패하였습니다.");
			}

		} catch (Exception e) {
			System.out.println("[에러]관리자 로그인 실패하였습니다.");
			e.printStackTrace();
		}
	}

	public void memberSearch() {
		System.out.println("전체 회원 정보를 조회합니다.");
		List<MemberVo> memberVoList = new MemberDao().memberSearch();

		System.out.println("------------ 회 원 정 보------------");
		System.out.println("==================================");

		for (int i = 0; i < memberVoList.size(); i++) {

			MemberVo temp = memberVoList.get(i);

			String no = temp.getNo();
			String id = temp.getId();
			String pwd = temp.getPwd();
			String name = temp.getName();
			String nick = temp.getNick();
			int weight = temp.getWeight();
			Timestamp enrollDate = temp.getEnrollDate();
			String quitYn = temp.getQuitYn();
			Timestamp editDate = temp.getEditDate();

			System.out.println(no + " | " + id + " | " + pwd + " | " + name + " | " + nick + " |\n " + weight + " | "
					+ enrollDate + " | " + quitYn + " | " + editDate);

		}

	}

	public void memberSearchDe() {
		System.out.println("회원 번호를 입력하여 조회하세요.: ");
		String no = Inpututil.sc.nextLine();

		MemberVo vo = new MemberVo();
		vo.setNo(no);

		new MemberDao().memberSearchDe(no);

	}

	public void myPage() {

		System.out.println("-----------------");
		System.out.println(" MY PAGE");
		System.out.println("=================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 닉네임 변경");
		System.out.println("3. 몸무게 변경");

		int result = Inpututil.getint();
		if (result == 1) {
			updatePwd();
		} else if (result == 2) {
			updateNick();
		} else if (result == 3) {
			updateWeight();
		} else {
			System.out.println("번호를 잘못 누르셨습니다. 다시 선택하여 주십시오.");

		}

	}

	public void updateWeight() {
		if (Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}
		System.out.println("수정하실 몸무게를 입력하세요.: ");
		int newWeight = Inpututil.getint();

		System.out.println("몸무게를 수정하시겠습니까?(Y/N)");

		String input = Inpututil.sc.nextLine();

		if (input.equalsIgnoreCase("Y")) {

			MemberVo vo = new MemberVo();
			vo.setId(Main.loginMember.getId());
			vo.setWeight(newWeight);

			int result = new MemberService().updateWeight(vo);

		} else {
			return;
		}

	}

	public void updatePwd() {
		if (Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}

		System.out.println("현재 비밀번호를 입력하세요.: ");
		String pwd = Inpututil.sc.nextLine();

		System.out.println("변경하실 비밀번호를 입력하세요.: ");
		String newPwd = Inpututil.sc.nextLine();

		System.out.println("변경하실 비밀번호를 다시 입력하세요.: ");
		String newPwd2 = Inpututil.sc.nextLine();

		MemberVo vo = new MemberVo();
		vo.setId(Main.loginMember.getId());
		vo.setPwd(pwd);
		vo.setPwd2(newPwd);
		vo.setPwd3(newPwd2);

		int result = new MemberService().updatePwd(vo);

	}

	public String login(MemberVo vo) {
		vo = new MemberVo();
		vo.setId(Main.loginMember.getId());
		vo.setPwd(Main.loginMember.getPwd());
		String x = "";

		return x;
	}

	public void updateNick() {

		if (Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}
		System.out.println("현재 사용하는 닉네임을 입력하세요.: ");
		String nick = Inpututil.sc.nextLine();

		System.out.println("변경하실 닉네임을 입력하세요.: ");
		String newNick = Inpututil.sc.nextLine();

		System.out.println("닉네임을 수정하시겠습니까?(Y/N)");

		String input = Inpututil.sc.nextLine();

		if (input.equalsIgnoreCase("Y")) {

			MemberVo vo = new MemberVo();
			vo.setId(Main.loginMember.getId());
			vo.setNick(nick);
			vo.setNick2(newNick);

			int result = new MemberService().updateNick(vo);

		} else {
			return;
		}

	}

	public void community() {

		System.out.println("-----------------");
		System.out.println(" COMMUNITY");
		System.out.println("=================");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 확인");

		int result = Inpututil.getint();
		if (result == 1) {
			write();
		} else if (result == 2) {
			showList();
		} else {
			System.out.println("번호를 잘못 누르셨습니다. 다시 선택하여 주십시오.");

		}

	}

	public void write() {

		if (Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}

		System.out.println("======= 커뮤니티 =======");
		System.out.println("---------------------");

		System.out.println("제목: ");
		String title = Inpututil.sc.nextLine();
		System.out.println("내용: ");
		String content = Inpututil.sc.nextLine();

		String memberNo = Main.loginMember.getNo();

		// 데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(memberNo);

		int result = new MemberService().write(vo);
		// insert 결과에 따라 로직 처리
		if (result == 1) {
			System.out.println("게시글을 작성하였습니다.");
			System.out.println("====================================");
			System.out.println();
		} else {
			System.out.println("게시글 작성에 실패하였습니다.");
		}

	}

	public void showList() {
		
		Scanner sc = new Scanner(System.in);

		List<BoardVo> boardVoList = new MemberService().showList();

		System.out.println("------ 게시판 ------");

		for (int i = 0; i < boardVoList.size(); ++i) {
			BoardVo temp = boardVoList.get(i);

			int no = temp.getPostNum();
			String title = temp.getTitle();
			Timestamp editDate = temp.getWriteDate();
			String name = temp.getName();
			String content = temp.getContent();

			System.out.println(no + " | " + title + " | " + content + " | " + editDate + " | " + name);

		}

		System.out.println("메인메뉴로 돌아가기 : 숫자한개");

		int num = sc.nextInt();

		if (num == 0 || num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7 || num == 8
				|| num == 9) {
			System.out.println("전 메뉴로 돌아갑니다");
			return;
		} else {

		}

	}

}
