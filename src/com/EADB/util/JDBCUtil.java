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
 *创建时间：2017年8月21日上午9:05:29
 *项目名称：
		2017_EADBproject
 *@author 罗士朝
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:JDBCUtil.java
 *类说明：
 *		JDBC连接文件。
 */

public class JDBCUtil {
	private static String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8";
	private static String username="root";
	private static String password="123456";
	
	//用静态代码块实现注册数据库驱动，只加载一次，并且是共享的。
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("数据库加载失败！");
		}
	}
	
	//写函数从而完成与数据库的连接。
	public static Connection getConnection() {
		//用connection方法获取链接。
		Connection con;
		try {
			con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取数据库连接失败！");
			return null;
		}	
	}
	/*
	 * 添加、修改、删除
	 */
	public static boolean InsertUpdateDeleteExcute(String sql,
			ArrayList<Object> paras) {
		// 连接数据库
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean flag = false;

		int index = 1; // 索引

		try {
			pst = conn.prepareStatement(sql);

			if (paras != null && paras.size() > 0) {
				pst.clearParameters();

				// 添加参数
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}

			// 执行
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
	 * 查询返回单个对象
	 */
	public static <T> T findBySingleObject(String sql, ArrayList<Object> paras,
			Class<T> cls) {
		// 连接数据库
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		T objectSingle = null;
		int index = 1; // 索引
		try {
			pst = conn.prepareStatement(sql);
			if (paras != null && paras.size() > 0) {
				pst.clearParameters();
				// 添加参数
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}
			// 执行
			rs = pst.executeQuery();
			// 获取元数据
			ResultSetMetaData rsms = rs.getMetaData();
			// 获取列数
			int colLength = rsms.getColumnCount();
			// 循环
			while (rs.next()) {
				objectSingle = cls.newInstance(); // 实例对象
				// 循环列数
				for (int i = 0; i < colLength; i++) {
					// 列名
					String columnName = rsms.getColumnName(i + 1); // 列的索引是从1开始的
					Object columnValue = rs.getObject(columnName); // 对应列名所对应的值
					if (columnValue == null) {
						columnValue = "";
					}
					// 反射
					Field field = cls.getDeclaredField(columnName);
					field.setAccessible(true); // 设置可访问权限
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
	 * 查询返回集合对象
	 */
	public static <T> List<T> QueryListExcute(String sql, ArrayList<Object> paras,
			Class<T> cls) {
		List<T> list = new ArrayList<T>();	
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		T objectSingle = null;
		int index = 1; // 索引
		try {
			pst = conn.prepareStatement(sql);
			if (paras != null && paras.size() > 0) {
				pst.clearParameters();
				// 添加参数
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}
			// 执行
			rs = pst.executeQuery();
			// 获取元数据
			ResultSetMetaData rsms = rs.getMetaData();
			// 获取列数
			int colLength = rsms.getColumnCount();
			// 循环
			while (rs.next()) {
				objectSingle = cls.newInstance(); // 实例对象
				// 循环列数
				for (int i = 0; i < colLength; i++) {
					// 列名
					String columnName = rsms.getColumnName(i + 1); // 列的索引是从1开始的
					Object columnValue = rs.getObject(columnName); // 对应列名所对应的值
					if (columnValue == null) {
						columnValue = "";
					}
					// 反射
					Field field = cls.getDeclaredField(columnName);
					field.setAccessible(true); // 设置可访问权限
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
	
	//释放数据库连接资源。
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
	//方法重写。
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
	 * 查询数据： 带有分页功能
	 */
	public static <T> List<T> getObjectListEntity(String sql,ArrayList<Object> paras,PageEntity pageEntity, Class<T> cls) {
		
		List<T> list = new ArrayList<T>();
		T t=null;
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		int index = 1;
		// 获取连接
		//getConnection();
		
		try {
			// 创建prepareStatement
			sql=sql+"  limit "+ (pageEntity.getPageIndex()-1)*pageEntity.getPageSize() +","+pageEntity.getPageSize();
			pst = conn.prepareStatement(sql);

			// 添加参数
			if (paras!= null && paras.size() > 0) {
				pst.clearParameters();
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}

			// 执行
			rs = pst.executeQuery();

			// 获取元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 对象元数据中的列数
			int count = rsmd.getColumnCount();

			while (rs.next()) {
				t = cls.newInstance();
				for (int i = 0; i < count; i++) {
					String columnName = rsmd.getColumnName(i + 1);
					Object columnValue = rs.getObject(columnName);

					if (columnValue == null) {
						columnValue = "";

					}

					// 反射
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
	  * 获取查询分页的总页数
	  */
	public static int getTotalPage(String sql,ArrayList<Object> paras,PageEntity pageEntity){
		// 获取连接
		//getConnection();
		
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int index=1;
		int count=0;  //是数据库查询出来 的总数据
		int totalPage=0;  //总页数
		try {
			// 创建prepareStatement;
			pst = conn.prepareStatement(sql);

			// 添加参数
			if (paras!= null && paras.size() > 0) {
				pst.clearParameters();
				for (int i = 0; i < paras.size(); i++) {
					pst.setObject(index++, paras.get(i));
				}
			}

			// 执行
			rs = pst.executeQuery();
			if(rs.next())
			{
				//默认给总条数一个别名:  totalCount
				count =rs.getInt("totalPage");
			}else
			{
				count=0;
			}
			
			//计算总页数
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
