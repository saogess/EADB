package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.AdminDao;
import com.EADB.model.ManagerEntity;
import com.EADB.util.JDBCUtil;


/**
 * ����ʱ�䣺2017��8��19�� ����3:07:02 ��Ŀ���ƣ�ZBDBProject
 * 
 * @author Alex
 * @version 1.0
 * @since JDK 1.7.0_21 �ļ����ƣ�UserDao.java ��˵�����û����ݴ���ʵ����
 */
public class AdminDaoImp implements AdminDao {
	/*
	 * ע��
	 */
	public boolean regist(ManagerEntity userEntity) {
		boolean flag = false;
		// ׼��sql���
		String strsql = "insert into admin (userName,loginname,password,photo,email) values (?,?,?,?,?)";
		// ׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getUserName());
		paras.add(userEntity.getLoginName());
		paras.add(userEntity.getPassword());
		paras.add(userEntity.getPhoto());
		paras.add(userEntity.getEmail());
		// ���ù���������
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}

	/*
	 * �û���¼
	 */
	@Override
	public ManagerEntity userLogin(ManagerEntity userEntity,int type) {
		// ׼��sql���
		String strsql = "select * from admin where loginName=? and password=?";
		// ׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getLoginName());
		paras.add(userEntity.getPassword());
		// ���ù���������
		ManagerEntity uEntity = JDBCUtil.findBySingleObject(strsql, paras,
				ManagerEntity.class);
		return uEntity != null ? uEntity : null;
	}
	
	/*
	 * ɾ������
	 */
	public boolean managerDelete(ManagerEntity userEntity) {
		
		boolean flag = false;

		String strsql = "delete from admin where loginName=?"; // ?��ʾһ��ռλ�����������ͽ�Ԥ�������

		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getLoginName());

		// ���ù���������
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		return flag;
	}

	/*
	 * ��֤�û����Ƿ���ȷ
	 */
	@Override
	public boolean validataLoginName(String loginName) {
		// ׼��sql���
		String strsql = "select * from admin where loginName=?";
		// ׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(loginName);
		// ���ù���������
		ManagerEntity uEntity = JDBCUtil.findBySingleObject(strsql, paras,
				ManagerEntity.class);
		return uEntity != null ? true : false;
	}

	/*
	 * ��ѯ���е��û�
	 */
	public List<ManagerEntity> queryUserInfo() {
		List<ManagerEntity> userList = new ArrayList<ManagerEntity>();
		// ׼����ѯsql���
		String strSql = "select * from admin";
		//û�в����Ϳ��Դ���null
		userList =JDBCUtil.QueryListExcute(strSql, null, ManagerEntity.class);	
		return userList;
	}
	/*
	 * ����Ա������Ϣ��ѯ
	 */
	public ManagerEntity findByloginName(String loginName) {
		//׼��sql��䡣
		String sql="select * from admin where loginName=?";
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(loginName);
		ManagerEntity m=JDBCUtil.findBySingleObject(sql, paras, ManagerEntity.class);
		return m;
	}

	/* 
	 * �޸�
	 */
	public boolean managerUpdate(ManagerEntity userEntity) {
		boolean flag = false;
		// ׼��sql���
		String strsql = "update admin set password=?,userName=?,photo=?,email=? where loginName=?";
		// ׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getPassword());
		paras.add(userEntity.getUserName());
		paras.add(userEntity.getPhoto());
		paras.add(userEntity.getEmail());
		paras.add(userEntity.getLoginName());
		// ���ù���������
		flag = JDBCUtil.InsertUpdateDeleteExcute(strsql, paras);
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.EADB.dao.AdminDao#findUserByLoginNameAndPassword(com.EADB.model.ManagerEntity)
	 */
	@Override
	public ManagerEntity findUserByLoginNameAndPassword(ManagerEntity userEntity) {
		//sql���
		String sql="select * from admin "
				+ " where loginName=? and password=?";
		
		//����
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(userEntity.getLoginName());
		paras.add(userEntity.getPassword());
		
		//�������ݴ���������
		JDBCUtil jdbcUtil = new JDBCUtil();
		return jdbcUtil.findBySingleObject(sql, paras, ManagerEntity.class);
	}
	




}
