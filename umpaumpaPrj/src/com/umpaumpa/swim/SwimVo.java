package com.umpaumpa.swim;

public class SwimVo {
	
public SwimVo() {
		
	}
	
	public SwimVo(String strokeNo, String sName, int sKcal, String description) {
		super();
		this.strokeNo = strokeNo;
		this.sName = sName;
		this.sKcal = sKcal;
		this.description = description;
	}
	private String strokeNo;
	private String sName;
	private int sKcal;
	private String description;
	
	
	public String getStrokeNo() {
		return strokeNo;
	}
	public void setStrokeNo(String strokeNo) {
		this.strokeNo = strokeNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsKcal() {
		return sKcal;
	}
	public void setsKcal(int sKcal) {
		this.sKcal = sKcal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SwimVo [strokeNo=" + strokeNo + ", sName=" + sName + ", sKcal=" + sKcal + ", description=" + description
				+ "]";
	}


}
