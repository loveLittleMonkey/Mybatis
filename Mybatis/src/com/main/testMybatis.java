package com.main;

import java.util.Date;
import java.util.List;

import com.dao.EmpDaoImpl;
import com.dao.IEmpDao;
import com.entity.Emp;

public class testMybatis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IEmpDao empDao = new EmpDaoImpl();

		List<Emp> list = empDao.selectAll();
		System.out.println("全部的员工信息：");
		for (Emp em : list) {
			System.out.println("员工编号" + em.getEmpno() + "  员工姓名:" + em.getEmpName() + "  职位:" + em.getJob() + "部门："
					+ em.getDeptNo());

		}
		System.out.println("------------------------------------");

		// 固定选取
		Emp emp = empDao.selectOne();
		System.out.println("后台固定员工编号的选取信息");
		System.out.println("员工编号" + emp.getEmpno() + "  员工姓名:" + emp.getEmpName() + "  职位:" + emp.getJob());
		System.out.println("------------------------------------");

		// 根据员工编号灵活选取
		Emp emp2 = empDao.selectOneByEmpno(7902);
		System.out.println("前端可改员工编号的选取信息");
		System.out.println("员工编号" + emp2.getEmpno() + "  员工姓名:" + emp2.getEmpName() + "  职位:" + emp2.getJob());
		System.out.println("------------------------------------");

		/*
		 * Emp emp3 = new Emp(); emp3.setEmpno(4567); emp3.setEmpName("shabi");
		 * emp3.setJob("shaib"); emp3.setHireDate(new Date());
		 * emp3.setSalary(1300.0); emp3.setComm(25.0); emp3.setDeptNo(23);
		 * empDao.insertEmp(emp3); System.out.println("插入操作成功");
		 * System.out.println("------------------------------------");
		 */

		/*
		 * Emp emp3 = new Emp(); emp3.setEmpName("shabi"); emp3.setJob("shaib");
		 * emp3.setHireDate(new Date()); emp3.setSalary(1300.0);
		 * emp3.setComm(25.0); emp3.setDeptNo(23); empDao.insertEmpAutoId(emp3);
		 * System.out.println("自动插入的员工的员工编号是"+emp3.getEmpno());
		 * System.out.println("------------------------------------");
		 */

		/*
		 * empDao.deleteEmp(7942); System.out.println("删除操作后："); list =
		 * empDao.selectAll(); for (Emp em : list) { System.out.println("员工编号" +
		 * em.getEmpno() + "  员工姓名:" + em.getEmpName() + "  职位:" + em.getJob());
		 * 
		 * } System.out.println("------------------------------------");
		 */

		Emp emp4 = new Emp();
		emp4.setDeptNo(20);
		emp4.setEmpName("s");

		list = empDao.findEmpByExampleIf(emp4);
		System.out.println("动态选取获得信息");
		for (Emp em : list) {
			System.out.println("员工编号" + em.getEmpno() + "  员工姓名:" + em.getEmpName() + "  职位:" + em.getJob() + "部门："
					+ em.getDeptNo());

		}
		System.out.println("------------------------------------");

		int count = empDao.count();
		System.out.println("员工信息数据总数共有：" + count);
		System.out.println("------------------------------------");

		Emp emp5 = new Emp();
		emp5.setEmpno(7902);
		emp5.setEmpName("shabi");
		empDao.updateNameById(emp5);
		System.out.println("更新编号为7902的信息成功");
		System.out.println("------------------------------------");

	}

}
