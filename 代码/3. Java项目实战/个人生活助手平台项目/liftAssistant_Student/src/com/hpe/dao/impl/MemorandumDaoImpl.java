package com.hpe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hpe.dao.MemorandumDao;
import com.hpe.po.Memorandum;
import com.hpe.po.Users;
import com.hpe.util.DBUtil;
import com.hpe.util.DateFormat;

public class MemorandumDaoImpl implements MemorandumDao {

	@Override
	public List<Memorandum> queryMemorandum(int userid) {
		// 1、准备sql
		StringBuffer sql = new StringBuffer();
		sql.append("select * from memorandum where userId=?");
		// 2、链接数据库
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Memorandum> list = new ArrayList<>();
		// 3、预编译sql
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, userid);
			// 4、执行sql
			rs = pst.executeQuery();
			while (rs.next()) {
				Memorandum memo = new Memorandum();
				memo.setContent(rs.getString("content"));
				memo.setMemorandumId(rs.getInt("memorandum_id"));
				memo.setMemorandum_title(rs.getString("memorandum_title"));
				memo.setTime(rs.getString("time"));
				memo.setUserId(rs.getInt("userId"));
				list.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.realseDB(rs, pst, con);
		}
		return list;
	}

	@Override
	public Integer addMemorandum(Memorandum memorandum) {
		// 1、准备sql
		StringBuffer sql = new StringBuffer();
		sql.append("insert into memorandum(memorandum_title, time, content,userId)");
		sql.append(" values(?,?,?,?)");
		Object[] args = { memorandum.getMemorandum_title(), memorandum.getTime(), memorandum.getContent(),
				memorandum.getUserId() };
		// 2、链接数据库
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		int flag = 0;
		try {
			// 调用prepareStatement方法，能够获取生成的主键
			pst = con.prepareStatement(sql.toString());
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i + 1, args[i]);
			}
			flag = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.realseDB(null, pst, null);
		}
		return flag;
	}

	@Override
	public int updateMemorandum(Memorandum memo,int memoid) {
		// 1、准备sql
		StringBuffer sql = new StringBuffer();
		sql.append("update memorandum set memorandum_title=?,content=? where memorandum_id=?");

		// 2、链接数据库
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		int flag = 0;
		try {
			// 调用prepareStatement方法，能够获取生成的主键
			pst = con.prepareStatement(sql.toString());
			pst.setString(1, memo.getMemorandum_title());
			pst.setString(2, memo.getContent());
			pst.setInt(3, memoid);
			flag = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.realseDB(null, pst, con);
		}
		return flag;
	}
	
	@Override
	public int deleteMemorandum(int memoid) {
		// 1、准备sql
		StringBuffer sql = new StringBuffer();
		sql.append("delete from memorandum where memorandum_id=?");

		// 2、链接数据库
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		int flag = 0;
		try {
			// 调用prepareStatement方法，能够获取生成的主键
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, memoid);
			flag = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.realseDB(null, pst, con);
		}
		return flag;
	}

	@Override
	public Memorandum queryByMemoId(int memoid) {
		// 1、准备sql
		StringBuffer sql = new StringBuffer();
		sql.append("select * from memorandum where memorandum_id=?");
		// 2、链接数据库
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Memorandum memo = null;
		// 3、预编译sql
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, memoid);
			// 4、执行sql
			rs = pst.executeQuery();
			while (rs.next()) {
				memo = new Memorandum();
				memo.setContent(rs.getString("content"));
				memo.setMemorandumId(rs.getInt("memorandum_id"));
				memo.setMemorandum_title(rs.getString("memorandum_title"));
				memo.setTime(rs.getString("time"));
				memo.setUserId(rs.getInt("userId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.realseDB(rs, pst, con);
		}
		return memo;
	}



}
