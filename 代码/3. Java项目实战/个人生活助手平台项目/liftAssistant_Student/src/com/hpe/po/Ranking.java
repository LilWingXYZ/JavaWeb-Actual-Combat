package com.hpe.po;

/**
 * 游戏排行榜实体类
 */
public class Ranking {
	//游戏排行榜id
	private int rankingId;

	//用户id
	private int userId;
	
	//用户积分
	private int integral;
	
	//时间
	private String time;
	
	//用户名  供游戏排行榜中两个表连接时使用
	private String userName;

	public Ranking() {
		super();
	}
	
	public Ranking(int rankingId, int uerId, int integral, String time) {
		super();
		this.rankingId = rankingId;
		this.userId = userId;
		this.integral = integral;
		this.time = time;
	}

	public int getRankingId() {
		return rankingId;
	}

	public void setRankingId(int rankingId) {
		this.rankingId = rankingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Ranking [rankingId=" + rankingId + ", userId=" + userId + ", integral=" + integral + ", time=" + time
				+ "]";
	}
	
	


	
}
