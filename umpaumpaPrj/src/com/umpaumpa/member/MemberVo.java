package com.umpaumpa.member;

import java.sql.Timestamp;

public class MemberVo {
	
	
	public MemberVo() {
		super();
	}

	




	public MemberVo(String no, String id, String pwd, String pwd2, String pwd3, String name, String adminId,
			String adminPwd, String adminName, String nick, String nick2, String gender, double weight,
			Timestamp enrollDate, Timestamp modifyDate, String quitYn, Timestamp editDate, String title, String content,
			String teamCode, String teamName) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.pwd3 = pwd3;
		this.name = name;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.nick = nick;
		this.nick2 = nick2;
		this.gender = gender;
		this.weight = weight;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.quitYn = quitYn;
		this.editDate = editDate;
		this.title = title;
		this.content = content;
		this.teamCode = teamCode;
		this.teamName = teamName;
	}






	private String no;
	private String id;
	private String pwd;
	private String pwd2;
	private String pwd3;
	private String name;
	private String adminId;
	private String adminPwd;
	private String adminName;
	private String nick;
	private String nick2;
	private String gender;
	private double weight;
	private Timestamp enrollDate;
	private Timestamp modifyDate;
	private String quitYn;
	private Timestamp editDate;
	private String title;
	private String content;
	private String teamCode;
	private String teamName;
	
	
	
	
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", pwd3=" + pwd3 + ", name="
				+ name + ", adminId=" + adminId + ", adminPwd=" + adminPwd + ", adminName=" + adminName + ", nick="
				+ nick + ", nick2=" + nick2 + ", gender=" + gender + ", weight=" + weight + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", quitYn=" + quitYn + ", editDate=" + editDate + ", title=" + title
				+ ", content=" + content + ", teamCode=" + teamCode + ", teamName=" + teamName + "]";
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getPwd3() {
		return pwd3;
	}

	public void setPwd3(String pwd3) {
		this.pwd3 = pwd3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNick2() {
		return nick2;
	}

	public void setNick2(String nick2) {
		this.nick2 = nick2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Timestamp getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}

	public Timestamp getEditDate() {
		return editDate;
	}

	public void setEditDate(Timestamp editDate) {
		this.editDate = editDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	
	
	
}
