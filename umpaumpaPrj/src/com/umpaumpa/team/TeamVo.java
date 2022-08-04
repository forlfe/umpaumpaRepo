package com.umpaumpa.team;

import java.sql.Timestamp;

public class TeamVo {
	
	public TeamVo() {
			
		}
		
		private int code;
		private int cap;
		private String teamName;
		private Timestamp tenrollDate;
		private String status;
		private int record;
		
		public TeamVo(int code, int cap, String teamName, Timestamp tenrollDate, String status, int record) {
			this.code = code;
			this.cap = cap;
			this.teamName = teamName;
			this.tenrollDate = tenrollDate;
			this.status = status;
			this.record = record;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public int getCap() {
			return cap;
		}

		public void setCap(int cap) {
			this.cap = cap;
		}

		public String getTeamName() {
			return teamName;
		}

		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}

		public Timestamp getTenrollDate() {
			return tenrollDate;
		}

		public void setTenrollDate(Timestamp tenrollDate) {
			this.tenrollDate = tenrollDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getRecord() {
			return record;
		}

		public void setRecord(int record) {
			this.record = record;
		}

		@Override
		public String toString() {
			return "TeamVo [code=" + code + ", cap=" + cap + ", teamName=" + teamName + ", tenrollDate=" + tenrollDate
					+ ", status=" + status + ", record=" + record + "]";
		}
}
