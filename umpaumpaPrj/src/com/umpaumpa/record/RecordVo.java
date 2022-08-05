package com.umpaumpa.record;

import java.sql.Timestamp;

public class RecordVo {
	
	
	public RecordVo() {
		
	}
	
	



	public RecordVo(int numrec, int num, Timestamp swimDate, double kcal, int strokeNo, int min, String nick,
			String sName) {
		super();
		this.numrec = numrec;
		this.num = num;
		this.swimDate = swimDate;
		this.kcal = kcal;
		this.strokeNo = strokeNo;
		this.min = min;
		this.nick = nick;
		this.sName = sName;
	}







	private int numrec;
	private int num;
	private Timestamp swimDate;
	private double kcal;
	private int strokeNo;
	private int min;
	private String nick;
	private String sName;
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
	public Timestamp getSwimDate() {
		return swimDate;
	}
	public void setSwimDate(Timestamp swimDate) {
		this.swimDate = swimDate;
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
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	@Override
	public String toString() {
		return "RecordVo [numrec=" + numrec + ", num=" + num + ", swimDate=" + swimDate + ", kcal=" + kcal
				+ ", strokeNo=" + strokeNo + ", min=" + min + ", nick=" + nick + ", sName=" + sName + "]";
	}
	
	
	
	
	

}
