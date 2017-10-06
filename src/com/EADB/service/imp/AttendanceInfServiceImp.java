package com.EADB.service.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.EADB.dao.AttendanceInfDao;
import com.EADB.dao.imp.AttendanceInfDaoImp;
import com.EADB.model.Attendance;
import com.EADB.model.UserEntity;
import com.EADB.service.AttendanceInfService;

/**
 *����ʱ�䣺2017��9��21������8:25:23
 *��Ŀ���ƣ�2017_EADB_Project_Web
 *@author ��ʿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:AttendanceInfServiceImp.java
 *��˵�����û����ڵķ����ʵ��
 */

public class AttendanceInfServiceImp implements AttendanceInfService{

	//��ѯԱ��������Ϣ��(����Ա��id��ѯ)
	@Override
	public List<Attendance> findByUIdAttendanceInf(String userid) {
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		List<Attendance> list=aid.findByUserIdAttendanceInf(userid);
		return list;
	}

	//��ѯȫ��Ա��������Ϣ��
	@Override
	public List<Attendance> findAllAttendanceInf() {
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		List<Attendance> list=aid.findAllAttendanceInf();
		return list;
	}

	//ɾ��Ա��������Ϣ��������ɾ����
	@Override
	public boolean deleteByUidAttendanceInf(String uid) {
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		UserEntity u=aid.findIdByUid(uid);
		boolean flag=aid.deleteAttendanceInf(u.getuId());
		return flag;
	}

	//ɾ��Ա��������Ϣ������ձ�
	@Override
	public boolean deleteAllAttendanceInf() {
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		boolean flag=aid.deleteAllAttendanceInf();
		return flag;
	}
	
	//Ա�����ڲ�����Ա��ǩ����ǩ�ˡ�
	public boolean SignInInsert(String uid) throws ParseException{
		AttendanceInfDao aid=new AttendanceInfDaoImp();
		//��ѯ�û���Ϣ
		UserEntity u=aid.findIdByUid(uid);
		System.out.println(u);
		//����ǩ��ʱ�䡣
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		String time = sdf.format(date);   //������ת����ָ����ʱ���ʽ�ַ���
		//���ñ�׼ǩ��ʱ�䡣
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String time1=sdf1.format(date);
		String morning = "08:00:00";
		String noon="12:00:00";
		String afternoon="14:30:00";
		String night="18:00:00";
		Date now=sdf1.parse(time1);
		Date signIn1= sdf1.parse(morning);		
		Date signOff1=sdf1.parse(noon);		
		Date signIn2=sdf1.parse(afternoon);		
		Date signOff2=sdf1.parse(night);		
		//ǩ�����͵��жϡ�
		String type;
		String inf;
		if(now.getTime()>signOff1.getTime()){
			inf="����������";
			if(now.getTime()>=signOff1.getTime()&&now.getTime()<signIn2.getTime()){
				type = "����ǩ��";
			}else{
				type = "�ٵ��������õ��ͷ���";
			}
			if(now.getTime()>signOff2.getTime()){
				type = "����ǩ��";
			}else{
				type = "���ˣ������õ��ͷ���";
			}
		}else{
			inf="����������";
			if(now.getTime()<=signIn1.getTime()){
				type = "����ǩ��";
			}else{
				type = "�ٵ�";
			}
			if(now.getTime()>=signOff1.getTime()&&now.getTime()<signIn2.getTime()){
				type = "����ǩ��";
			}else{
				type = "���ˣ������õ��ͷ���";
			}
		}
		Attendance a=new Attendance(u.getuId(),uid,u.getUsername(),time,type,inf);
		boolean flag=aid.insertAttendanceInf(a);
		return flag;
	}
}
