package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Admin;

@Repository
public class AdminDaoImple implements AdminDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insertAdmin(Admin admin) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(admin);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public boolean checkAdmin(Admin admin) {
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Admin where uname = ? and passWord = ?");
				q.setString(0, admin.getUname());
				q.setString(1, admin.getPassWord());
				List<Admin> li = q.list();
				boolean flag = ! li.isEmpty();
				if(flag)
				admin.setRollno(li.get(0).getRollno());
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
		});
		return b;
	}

	@Override
	public String forgetPassword(String userName) {
		String password = hibernateTemplate.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Admin where uname = ?");
				q.setString(0, userName);
				List<Admin> li = q.list();
				String pass = null;
				if(!li.isEmpty())
					pass = li.get(0).getPassWord();
				tr.commit();
				session.flush();
				session.close();
				return pass;
			}
			
		});
		return password;
	}

}
