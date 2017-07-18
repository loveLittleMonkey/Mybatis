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
		System.out.println("ȫ����Ա����Ϣ��");
		for (Emp em : list) {
			System.out.println("Ա�����" + em.getEmpno() + "  Ա������:" + em.getEmpName() + "  ְλ:" + em.getJob() + "���ţ�"
					+ em.getDeptNo());

		}
		System.out.println("------------------------------------");

		// �̶�ѡȡ
		Emp emp = empDao.selectOne();
		System.out.println("��̨�̶�Ա����ŵ�ѡȡ��Ϣ");
		System.out.println("Ա�����" + emp.getEmpno() + "  Ա������:" + emp.getEmpName() + "  ְλ:" + emp.getJob());
		System.out.println("------------------------------------");

		// ����Ա��������ѡȡ
		Emp emp2 = empDao.selectOneByEmpno(7902);
		System.out.println("ǰ�˿ɸ�Ա����ŵ�ѡȡ��Ϣ");
		System.out.println("Ա�����" + emp2.getEmpno() + "  Ա������:" + emp2.getEmpName() + "  ְλ:" + emp2.getJob());
		System.out.println("------------------------------------");

		/*
		 * Emp emp3 = new Emp(); emp3.setEmpno(4567); emp3.setEmpName("shabi");
		 * emp3.setJob("shaib"); emp3.setHireDate(new Date());
		 * emp3.setSalary(1300.0); emp3.setComm(25.0); emp3.setDeptNo(23);
		 * empDao.insertEmp(emp3); System.out.println("��������ɹ�");
		 * System.out.println("------------------------------------");
		 */

		/*
		 * Emp emp3 = new Emp(); emp3.setEmpName("shabi"); emp3.setJob("shaib");
		 * emp3.setHireDate(new Date()); emp3.setSalary(1300.0);
		 * emp3.setComm(25.0); emp3.setDeptNo(23); empDao.insertEmpAutoId(emp3);
		 * System.out.println("�Զ������Ա����Ա�������"+emp3.getEmpno());
		 * System.out.println("------------------------------------");
		 */

		/*
		 * empDao.deleteEmp(7942); System.out.println("ɾ��������"); list =
		 * empDao.selectAll(); for (Emp em : list) { System.out.println("Ա�����" +
		 * em.getEmpno() + "  Ա������:" + em.getEmpName() + "  ְλ:" + em.getJob());
		 * 
		 * } System.out.println("------------------------------------");
		 */

		Emp emp4 = new Emp();
		emp4.setDeptNo(20);
		emp4.setEmpName("s");

		list = empDao.findEmpByExampleIf(emp4);
		System.out.println("��̬ѡȡ�����Ϣ");
		for (Emp em : list) {
			System.out.println("Ա�����" + em.getEmpno() + "  Ա������:" + em.getEmpName() + "  ְλ:" + em.getJob() + "���ţ�"
					+ em.getDeptNo());

		}
		System.out.println("------------------------------------");

		int count = empDao.count();
		System.out.println("Ա����Ϣ�����������У�" + count);
		System.out.println("------------------------------------");

		Emp emp5 = new Emp();
		emp5.setEmpno(7902);
		emp5.setEmpName("shabi");
		empDao.updateNameById(emp5);
		System.out.println("���±��Ϊ7902����Ϣ�ɹ�");
		System.out.println("------------------------------------");

	}

}
