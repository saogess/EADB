package com.EADB.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EADB.model.PageEntity;


/**
 *����ʱ�䣺2017��8��21������9:05:29
 *��Ŀ���ƣ�
		2017_EADBproject
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:JDBCUtil.java
 *��˵����
 *		JDBC�����ļ���
 */

public class JDBCUtil {
	private static String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8";
	private static String username="root";
	private static String password="123456";
	
	//�þ�̬�����ʵ��ע�����ݿ�������ֻ����һ�Σ������ǹ���ġ�
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���ݿ����ʧ�ܣ�");
		}
	}
	
	//д�����Ӷ���������ݿ�����ӡ�
	public static Connection getConnection() {
		//��connection������ȡ���ӡ�
		Connection con;
		try {
			con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
			return null;
		}	
	}
	/*
	 * ��ӡ��޸ġ�ɾ��
	 */
	public static boolean InsertUpdateDeleteExcute(String sql,
			ArrayList<Object> paras) {
		// �������ݿ�
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean flag = false;

		int index = 1; // ����

		try {
			pst = conn.prepareStatement(sql);

			if (paras != null && paras.size() > 0) {
				pst.clearParameters();

				// ��Ӳ���
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}

			// ִ��
			int result = pst.executeUpdate();
			flag = result > 0 ? true : false;

		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			close(conn, pst);
		}

		return flag;
	}

	/*
	 * ��ѯ���ص�������
	 */
	public static <T> T findBySingleObject(String sql, ArrayList<Object> paras,
			Class<T> cls) {
		// �������ݿ�
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		T objectSingle = null;
		int index = 1; // ����
		try {
			pst = conn.prepareStatement(sql);
			if (paras != null && paras.size() > 0) {
				pst.clearParameters();
				// ��Ӳ���
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}
			// ִ��
			rs = pst.executeQuery();
			// ��ȡԪ����
			ResultSetMetaData rsms = rs.getMetaData();
			// ��ȡ����
			int colLength = rsms.getColumnCount();
			// ѭ��
			while (rs.next()) {
				objectSingle = cls.newInstance(); // ʵ������
				// ѭ������
				for (int i = 0; i < colLength; i++) {
					// ����
					String columnName = rsms.getColumnName(i + 1); // �е������Ǵ�1��ʼ��
					Object columnValue = rs.getObject(columnName); // ��Ӧ��������Ӧ��ֵ
					if (columnValue == null) {
						columnValue = "";
					}
					// ����
					Field field = cls.getDeclaredField(columnName);
					field.setAccessible(true); // ���ÿɷ���Ȩ��
					field.set(objectSingle, columnValue);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pst);
		}
		return objectSingle;
	}

	/*
	 * ��ѯ���ؼ��϶���
	 */
	public static <T> List<T> QueryListExcute(String sql, ArrayList<Object> paras,
			Class<T> cls) {
		List<T> list = new ArrayList<T>();	
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		T objectSingle = null;
		int index = 1; // ����
		try {
			pst = conn.prepareStatement(sql);
			if (paras != null && paras.size() > 0) {
				pst.clearParameters();
				// ��Ӳ���
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}
			// ִ��
			rs = pst.executeQuery();
			// ��ȡԪ����
			ResultSetMetaData rsms = rs.getMetaData();
			// ��ȡ����
			int colLength = rsms.getColumnCount();
			// ѭ��
			while (rs.next()) {
				objectSingle = cls.newInstance(); // ʵ������
				// ѭ������
				for (int i = 0; i < colLength; i++) {
					// ����
					String columnName = rsms.getColumnName(i + 1); // �е������Ǵ�1��ʼ��
					Object columnValue = rs.getObject(columnName); // ��Ӧ��������Ӧ��ֵ
					if (columnValue == null) {
						columnValue = "";
					}
					// ����
					Field field = cls.getDeclaredField(columnName);
					field.setAccessible(true); // ���ÿɷ���Ȩ��
					field.set(objectSingle, columnValue);
				}
				
				list.add(objectSingle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pst);
		}
		return list;
	}
	
	//�ͷ����ݿ�������Դ��
	public static void close(Connection con,PreparedStatement ps) {
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//������д��
	public static void close(Connection con,PreparedStatement ps,ResultSet rs) {
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ѯ���ݣ� ���з�ҳ����
	 */
	public static <T> List<T> getObjectListEntity(String sql,ArrayList<Object> paras,PageEntity pageEntity, Class<T> cls) {
		
		List<T> list = new ArrayList<T>();
		T t=null;
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		int index = 1;
		// ��ȡ����
		//getConnection();
		
		try {
			// ����prepareStatement
			sql=sql+"  limit "+ (pageEntity.getPageIndex()-1)*pageEntity.getPageSize() +","+pageEntity.getPageSize();
			pst = conn.prepareStatement(sql);

			// ��Ӳ���
			if (paras!= null && paras.size() > 0) {
				pst.clearParameters();
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}

			// ִ��
			rs = pst.executeQuery();

			// ��ȡԪ����
			ResultSetMetaData rsmd = rs.getMetaData();
			// ����Ԫ�����е�����
			int count = rsmd.getColumnCount();

			while (rs.next()) {
				t = cls.newInstance();
				for (int i = 0; i < count; i++) {
					String columnName = rsmd.getColumnName(i + 1);
					Object columnValue = rs.getObject(columnName);

					if (columnValue == null) {
						columnValue = "";

					}

					// ����
					Field m = cls.getDeclaredField(columnName);
					m.setAccessible(true);
					m.set(t, columnValue);
				}

				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	 /**
	  * ��ȡ��ѯ��ҳ����ҳ��
	  */
	public static int getTotalPage(String sql,ArrayList<Object> paras,PageEntity pageEntity){
		// ��ȡ����
		//getConnection();
		
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int index=1;
		int count=0;  //�����ݿ��ѯ���� ��������
		int totalPage=0;  //��ҳ��
		try {
			// ����prepareStatement;
			pst = conn.prepareStatement(sql);

			// ��Ӳ���
			if (paras!= null && paras.size() > 0) {
				pst.clearParameters();
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}

			// ִ��
			rs = pst.executeQuery();
			if(rs.next())
			{
				//Ĭ�ϸ�������һ������:  totalCount
				count =rs.getInt("totalPage");
			}else
			{
				count=0;
			}
			
			//������ҳ��
			if(count%pageEntity.getPageSize()==0)
			{
				totalPage = count/pageEntity.getPageSize();
			}else
			{
				totalPage = count/pageEntity.getPageSize()+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			totalPage=0;
		}
		
		return totalPage;
	}
	
}
