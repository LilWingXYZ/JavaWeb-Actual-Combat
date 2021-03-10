package com.hpe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hpe.dao.RankingDao;
import com.hpe.po.Memorandum;
import com.hpe.po.Ranking;
import com.hpe.util.DBUtil;

public class RankingDaoImpl implements RankingDao{

	@Override
	public int guessScore(Ranking r) {
		// 1、准备sql
		StringBuffer sql = new StringBuffer();
		sql.append("insert into ranking(userId,integral,time) values(?,?,?)");
		// 2、链接数据库
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		int flag = 0;
		// 3、预编译sql
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, r.getUserId());
			pst.setInt(2, r.getIntegral());
			pst.setString(3, r.getTime());
			// 4、执行sql
			flag = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.realseDB(null, pst, con);
		}
		return flag;
	}

	@Override
	public List<Ranking> score() {
		// 1、准备sql
		StringBuffer sql = new StringBuffer();
		sql.append("select userName,integral,time ");
		sql.append("from users,ranking ");
		sql.append("where users.userId=ranking.userId ");
		sql.append("order by integral desc limit 10");
		// 2、链接数据库
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		List<Ranking> list = new ArrayList<>();
		Ranking rank = null;
		ResultSet rs = null;
		// 3、预编译sql
		try {
			pst = con.prepareStatement(sql.toString());
			// 4、执行sql
			rs = pst.executeQuery();
			while(rs.next()) {
				rank = new Ranking();
				rank.setIntegral(rs.getInt("integral"));
				rank.setUserName(rs.getString("userName"));
				rank.setTime(rs.getString("time"));
				list.add(rank);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.realseDB(rs, pst, con);
		}
		return list;
	}

}
