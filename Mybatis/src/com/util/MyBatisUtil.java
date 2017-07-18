package com.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private MyBatisUtil() {
	}

	private static final String RESOURCE = "mybatis-config.xml";
	private static SqlSessionFactory sqlSessionFactory = null;
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = builder.build(reader);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ExceptionInInitializerError("��ʼ��MyBatis�������������ļ������ݿ�");

		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public static SqlSession getSession() {
		// sessionTL��get()�������ݵ�ǰ�̷߳������Ӧ���߳��ڲ�������
		// Ҳ����������Ҫ��Session�����߳�����¹������ݿ������ǲ���ȫ�ġ�
		// ThreadLocal��֤��ÿ���̶߳����Լ���Session��
		SqlSession session = threadLocal.get();
		// ���sessionΪnull�����һ���µ�session
		if (session == null) {
			session = (sqlSessionFactory != null) ? sqlSessionFactory.openSession() : null;
			threadLocal.set(session); // 5
		}
		return session;
	}

	public static void closeSession() {
		SqlSession session = (SqlSession) threadLocal.get(); // 2
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}
}