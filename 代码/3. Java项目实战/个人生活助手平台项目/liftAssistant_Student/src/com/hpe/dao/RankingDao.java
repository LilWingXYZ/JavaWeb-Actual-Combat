package com.hpe.dao;

import java.util.List;

import com.hpe.po.Memorandum;
import com.hpe.po.Ranking;
import com.hpe.po.Users;

public interface RankingDao {

	//将用户积分写入数据库
	public int guessScore(Ranking r);
	//游戏排行榜
	public List<Ranking> score();
	
}
