package com.EADB.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.EADB.dao.UserDao;
import com.EADB.model.FileEntity;
import com.EADB.model.LeaveNum;
import com.EADB.model.UserEntity;
import com.EADB.util.JDBCUtil;

/**
 *����ʱ�䣺2017��9��18������9:58:34
 *��Ŀ���ƣ�user
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:UserDaoImpl.java
 *��˵����
 */

public class UserDaoImpl implements UserDao {
	//ע��
	public boolean UserRegist(UserEntity u){
		boolean flag=false;
		//׼��SQL���
		String sql="insert into userinf(userid,username,userpassword,usergender,useremail,userphone,userbirthday,useraddress,userdept) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		//׼��������ֵ
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(u.getUserid());
		list.add(u.getUsername());
		list.add(u.getUserpassword());
		list.add(u.getUsergender());
		list.add(u.getUseremail());
		list.add(u.getUserphone());
		list.add(u.getUserbirthday());
		list.add(u.getUseraddress());
		list.add(u.getUserdept());
		/*list.add(u.getuPicUrl());*/
		//�������ݿ⹫��������
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}

	/*
	 * �û���¼
	 */
	@Override
	public UserEntity UserLogin(UserEntity u,int type) {
		//׼��SQL���
				String sql1 = "select * from userinf where userid=?";
				String sql2 = "select * from userinf where userid=? and userpassword=?";
				//׼��SQL������ֵ
				ArrayList<Object> paras = new ArrayList<Object>();
				//�ֻ�����֤����
				if(type==0){
					paras.add(u.getUserid());
					u=JDBCUtil.findBySingleObject(sql1, paras,UserEntity.class);
				}
				//��¼��֤����
				if(type==1){
					paras.add(u.getUserid());
					paras.add(u.getUserpassword());
					u=JDBCUtil.findBySingleObject(sql2, paras,UserEntity.class);
				}
				//�������ݿ⹫��������
				return u != null ? u : null;
	}
	
	
	/*
	 * ��֤�û�����Ƿ���ȷ
	 */
	@Override
	public boolean validataUPhone(String userid) {
		//׼��SQL���
				String sql = "select * from userinf where userid=?";
				//׼��SQL������ֵ
				ArrayList<Object> paras = new ArrayList<Object>();
				paras.add(userid);
				//�������ݿ⹫��������
				UserEntity u=JDBCUtil.findBySingleObject(sql, paras,UserEntity.class);
				return u != null ? true : false;
	}
	
	
	/*
	 * ��ѯ����
	 */
	public List<UserEntity> findAllUserEntity(){
		List<UserEntity> list=new ArrayList<UserEntity>();
		//׼��SQL���
		String sql="select * from userinf";
		//�������ݿ����
		list=JDBCUtil.QueryListExcute(sql, null, UserEntity.class);
		return list;
	}
	
	/*
	 * ��ѯ����
	 */
	public List<UserEntity> findByuNameUserEntity(String username){
		List<UserEntity> list=new ArrayList<UserEntity>();
		//׼��SQL���
		String sql="select * from userinf where username like ?";
		//�������ݿ����
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(username+"%");
		list=JDBCUtil.QueryListExcute(sql, paras, UserEntity.class);
		return list;
	}
	
	/*
	 * ��ѯ����(��ȷ)
	 */
	public UserEntity findByuName(String username){
		//׼��SQL���
		String sql="select * from userinf where username=?";
		//�������ݿ����
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(username);
		return JDBCUtil.findBySingleObject(sql, paras, UserEntity.class);
	}
	
	/*
	 * ��ѯ����(��ȷ)
	 */
	public UserEntity findByuId(String uId){
		//׼��SQL���
		String sql="select * from userinf where userid=?";
		//�������ݿ����
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(uId);
		return JDBCUtil.findBySingleObject(sql, paras, UserEntity.class);
	}
	
	/*
	 * �޸�
	 */
	public boolean userEntityUpdate(UserEntity u){
		boolean flag=false;
		//׼��SQL���
		String sql="update userinf set userpassword=?,useremail=?,userphone=?,useraddress=? where username=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(u.getUserpassword());
		list.add(u.getUseremail());
		list.add(u.getUserphone());
		list.add(u.getUseraddress());
		list.add(u.getUsername());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	/*
	 * ɾ��
	 */
	public boolean userEntityDelete(UserEntity u){
		boolean flag=false;
		//׼��SQL���
		String sql="delete from userinf where userid=?";
		//׼��������ֵ
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(u.getUserid());
		//�������ݿ����
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	
	//����ٴ����������Ϣ
	public boolean NumberRegist(LeaveNum ln){
		boolean flag=false;
		//׼��SQL���
		String sql="insert into leavenum(username,lnNum) values(?,?)";
		//׼��������ֵ
		ArrayList<Object> paras = new ArrayList<Object>();
		paras.add(ln.getUsername());
		paras.add(ln.getLnNum());
		//�������ݿ⹫��������
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, paras);
		return flag;
	}
	
	//�ϴ�ͷ��
	public boolean FileInsert(FileEntity f){
		boolean flag=false;
		//׼��SQL���
		String sql="insert into filepic(userid,username,userpic,fDate) "
				+ "values(?,?,?,?)";
		//׼��������ֵ
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(f.getUserid());
		list.add(f.getUsername());
		list.add(f.getUserpic());
		list.add(f.getfDate());
		//�������ݿ⹫��������
		flag=JDBCUtil.InsertUpdateDeleteExcute(sql, list);
		return flag;
	}
	
	//��ѯͷ��
	public FileEntity findFile(String username){
		//׼��SQL���
		String sql="select * from filepic where username=?";
		//�������ݿ����
		ArrayList<Object> paras=new ArrayList<Object>();
		paras.add(username);
		return JDBCUtil.findBySingleObject(sql, paras, FileEntity.class);
	}

}
