package com.eshore.dao;

import java.util.Vector;

import com.eshore.pojo.Correspond;

public interface CorrespondDao {
	public int addCorrespond(Correspond corr)throws Exception;
	public Vector<Correspond> queryByUid(int uid)throws Exception;

}
