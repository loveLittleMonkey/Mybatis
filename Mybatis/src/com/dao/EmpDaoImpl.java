
package com.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.entity.Emp;
import com.util.MyBatisUtil;

public class EmpDaoImpl implements IEmpDao {

	@Override
	public List<Emp> selectAll() {
		SqlSession session = MyBatisUtil.getSession();
		List<Emp> list = new ArrayList<Emp>();
		try {

			list = session.selectList("com.dao.IEmpDao.selectAll");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return list;
	}
	/*
	 * @Override public List<Emp> selectAll() { String resource =
	 * "mybatis-config.xml"; Reader reader = null; SqlSessionFactory factory = null;
	 * SqlSession session = null; List<Emp> list = new ArrayList<Emp>(); try {
	 * reader = Resources.getResourceAsReader(resource); SqlSessionFactoryBuilder
	 * builder = new SqlSessionFactoryBuilder(); factory = builder.build(reader);
	 * session = factory.openSession(); list =
	 * session.selectList("com.dao.IEmpDao.selectAll"); } catch (IOException e1) {
	 * // TODO Auto-generated catch block e1.printStackTrace(); } finally {
	 * session.close(); } return list; }
	 */

	@Override
	public Emp selectOne() {
		SqlSession session = MyBatisUtil.getSession();
		Emp emp = new Emp();
		try {
			emp = session.selectOne("com.dao.IEmpDao.selectOne");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return emp;
	}

	@Override
	public Emp selectOneByEmpno(int i) {
		SqlSession session = MyBatisUtil.getSession();
		Emp emp = new Emp();
		try {

			emp = session.selectOne("com.dao.IEmpDao.selectOneByEmpno", i);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return emp;
	}

	@Override
	public void insertEmp(Emp emp) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisUtil.getSession();

		try {

			session.insert("com.dao.IEmpDao.insertEmp", emp);
			session.commit();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}

	}

	@Override
	public void insertEmpAutoId(Emp emp) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisUtil.getSession();

		try {

			session.insert("com.dao.IEmpDao.insertEmpAutoId", emp);
			session.commit();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
	}

	@Override
	public void deleteEmp(int i) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisUtil.getSession();

		try {
			session.delete("com.dao.IEmpDao.deleteEmp", i);
			session.commit();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
	}

	@Override
	public List<Emp> findEmpByExampleIf(Emp emp) {
		SqlSession session = MyBatisUtil.getSession();
		List<Emp> list = new ArrayList<Emp>();
		try {

			list = session.selectList("com.dao.IEmpDao.findEmpByExampleIf",emp);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return list;
	}

	@Override
	public int count() {
		SqlSession session = MyBatisUtil.getSession();
		int count =0;
		try {

			count  = session.selectOne("com.dao.IEmpDao.count");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
		return count;
	}

	@Override
	public void updateNameById(Emp emp1) {
		SqlSession session = MyBatisUtil.getSession();
		try {

			session.update("com.dao.IEmpDao.updateNameById", emp1);
			session.commit();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
	}

}