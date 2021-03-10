package com.hpe.dao;

import java.util.List;

import com.hpe.po.Memorandum;

import com.hpe.po.Memorandum;
import com.hpe.po.Users;

public interface MemorandumDao {
	//查看备忘录
	public List<Memorandum> queryMemorandum(int userid);
	//添加备忘录
	public Integer addMemorandum(Memorandum memorandum);
	//修改备忘录
	public int updateMemorandum(Memorandum memo, int memoid);
	//删除备忘录
	public int deleteMemorandum(int memoid);
	//根据备忘录ID查找
	public Memorandum queryByMemoId(int memoid);

	
}
