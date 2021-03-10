package com.hp.day7.forum;

import java.util.Date;

public class Reply {
	
	private int replyId;
	
	private String content;
	
	private Date creatDate;

	private User userName;

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public User getUserName() {
		return userName;
	}

	public void setUserName(User userName) {
		this.userName = userName;
	}
	
	
}
