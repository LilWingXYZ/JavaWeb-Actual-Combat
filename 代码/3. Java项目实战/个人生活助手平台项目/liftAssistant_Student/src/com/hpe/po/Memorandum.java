package com.hpe.po;

public class Memorandum {
	
	// 备忘录ID
	private int memorandumId;

	// 标题
	private String memorandum_title;

	// 时间
	private String times;

	// 内容
	private String content;

	// 用户ID
	private int userId;
	
	public Memorandum() {
		
	}
	
	public Memorandum(String memorandum_title, String times, String content, int userId) {
		super();
		this.memorandum_title = memorandum_title;
		this.times = times;
		this.content = content;
		this.userId = userId;
	}

	public int getMemorandumId() {
		return memorandumId;
	}

	public void setMemorandumId(int memorandumId) {
		this.memorandumId = memorandumId;
	}

	public String getMemorandum_title() {
		return memorandum_title;
	}

	public void setMemorandum_title(String memorandum_title) {
		this.memorandum_title = memorandum_title;
	}

	public String getTime() {
		return times;
	}

	public void setTime(String time) {
		this.times = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Memorandum [memorandumId=" + memorandumId + ", memorandum_title=" + memorandum_title + ", times="
				+ times + ", content=" + content + ", userId=" + userId + "]";
	}
	
	
}
