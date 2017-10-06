package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.ManagerInfDao;
import com.EADB.model.Manager;
import com.EADB.util.JDBCUtil;

/**
 *����ʱ�䣺2017��8��21������9:21:55
 *��Ŀ���ƣ�2017_EADBproject
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:managerInfDao.java
 *��˵����
 *		������Ϣ����ز�����
 */

public class ManagerInfDaoImp implements ManagerInfDao{
	//�����¼�Ĳ�����
	public Manager managerLogin(Manager m,int type) {
		//׼��sql��䡣
		String sql1="select * from manager where mid=?";
		String sql2="select * from manager where mid=? and mPassword=?";
		//׼��SQL������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		//������֤����
		if(type==0){
			paras.add(m.getMid());
			m=JDBCUtil.findBySingleObject(sql1, paras,Manager.class);
		}
		//��¼��֤����
		if(type==1){
			paras.add(m.getMid());
			paras.add(m.getmPassword());
			m=JDBCUtil.findBySingleObject(sql2, paras,Manager.class);
		}
		//�������ݿ⹫��������
		return m != null ? m : null;
	}
	
	//������Ϣ�Ĳ�ѯȫ��������
	public List<Manager> findAllManagerInf() {
		List<Manager> list=new ArrayList<Manager>();
		//׼��SQL���
		String sql="select * from manager";
		//�������ݿ����
		list=JDBCUtil.QueryListExcute(sql, null, Manager.class);
		return list;
	}
	
	//������Ϣ�Ĳ�ѯ���˲�����
	public Manager findByMidManagerInf(String mid) {
		//׼��SQL���
		String sql="select * from manager where mid=?";
		//�������ݿ����
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(mid);
		Manager m=JDBCUtil.findBySingleObject(sql, paras,Manager.class);
		return m;
	}
	
	//������Ϣ�Ĳ��������
	public boolean insertManagerInf(Manager m) {
		boolean flag=false;
		//׼��SQL���
		String sql="insert into manager(mid,managername,mPassword,gender,birthday,phonenumber,address,mail,pictureurl,position) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(m.getMid());
		list.add(m.getManagername());
		list.add(m.getmPassword());
		list.add(m.getGender());
		list.add(m.getBirthday());
		list.add(m.getPhonenumber());
		list.add(m.getAddress());
		list.add(m.getMail());
		list.add(m.getPictureurl());
		list.add(m.getPosition());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//������Ϣ���޸Ĳ�����
	public boolean updateManagerInf(Manager m) {
		boolean flag=false;
		//׼��SQL���
		String sql="update manager set mPassword=?,phonenumber=?,address=?,mail=? where mid=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(m.getmPassword());
		list.add(m.getPhonenumber());
		list.add(m.getAddress());
		list.add(m.getMail());
		list.add(m.getMid());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//������Ϣ��ɾ��������
	public boolean deleteManagerInf(Manager m) {
		boolean flag=false;
		//׼��SQL���
		String sql="delete from manager where mid=? and managername=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(m.getMid());
		list.add(m.getManagername());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}

}
