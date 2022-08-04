package com.umpaumpa.teamjoin;

public class TeamJoinVo {
	
	private int key;
	private int memberNum;
	private int teamCode;
	
	public TeamJoinVo() {
		
	}
	
	
	public TeamJoinVo(int key, int memberNum, int teamCode) {
		super();
		this.key = key;
		this.memberNum = memberNum;
		this.teamCode = teamCode;
	}
	@Override
	public String toString() {
		return "TeamJoinVo [key=" + key + ", memberNum=" + memberNum + ", teamCode=" + teamCode + "]";
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(int teamCode) {
		this.teamCode = teamCode;
	}
	
	
	
}