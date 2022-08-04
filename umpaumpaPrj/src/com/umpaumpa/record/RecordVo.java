package com.umpaumpa.record;

import java.sql.Timestamp;

public class RecordVo {
	
	
	public RecordVo() {
		
	}
	
	
	public RecordVo(int numrec, int num, Timestamp date, double kcal, int strokeNo, int min, String nick) {
		
		this.numrec = numrec;
		this.num = num;
		this.date = date;
		this.kcal = kcal;
		this.strokeNo = strokeNo;
		this.min = min;
		this.nick = nick;
	}
	private int numrec;
	private int num;
	private Timestamp date;
	private double kcal;
	private int strokeNo;
	private int min;
	private String nick;
	
	public int getNumrec() {
		return numrec;
	}
	public void setNumrec(int numrec) {
		this.numrec = numrec;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public double getKcal() {
		return kcal;
	}
	public void setKcal(double kcal) {
		this.kcal = kcal;
	}
	public int getStrokeNo() {
		return strokeNo;
	}
	public void setStrokeNo(int strokeNo) {
		this.strokeNo = strokeNo;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "RecordVo [numrec=" + numrec + ", num=" + num + ", date=" + date + ", kcal=" + kcal + ", strokeNo="
				+ strokeNo + ", min=" + min + ", nick=" + nick + "]";
	}
	
	
	
	

}
