package com.umpaumpa.member;

import java.sql.Timestamp;

public class BoardVo {
	
	private int postNum;
	private int Num;
	private Timestamp writeDate;
	private int viewCnt;
	private String title;
	private String content;
	private String name;
	
	public BoardVo() {
		
	}
	
	


	public BoardVo(int postNum, int num, Timestamp writeDate, int viewCnt, String title, String content, String name) {
		super();
		this.postNum = postNum;
		Num = num;
		this.writeDate = writeDate;
		this.viewCnt = viewCnt;
		this.title = title;
		this.content = content;
		this.name = name;
	}



	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getPostNum() {
		return postNum;
	}



	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}



	public int getNum() {
		return Num;
	}



	public void setNum(int num) {
		Num = num;
	}



	public Timestamp getWriteDate() {
		return writeDate;
	}



	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}



	public int getViewCnt() {
		return viewCnt;
	}



	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
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



	@Override
	public String toString() {
		return "BoardVo [postNum=" + postNum + ", Num=" + Num + ", writeDate=" + writeDate + ", viewCnt=" + viewCnt
				+ ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
