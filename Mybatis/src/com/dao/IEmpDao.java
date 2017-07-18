//步骤4 数据库接口
package com.dao;

import java.util.List;

import com.entity.Emp;

public interface IEmpDao {
	public List<Emp> selectAll();

	public Emp selectOne();

	public Emp selectOneByEmpno(int i);

	public void insertEmp(Emp emp);
	
	public void insertEmpAutoId(Emp emp);
	
	public void deleteEmp(int i);
	
	public List<Emp> findEmpByExampleIf(Emp emp);
	
	public int count();
	
	public void updateNameById(Emp emp);
}
