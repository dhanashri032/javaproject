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

import com.cdac.dto.Student;


@Repository
public class StudentDaoImple implements StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insertStudent(Student student) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(student);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public List<Student> selectAll(int rollno) {
		List<Student> stuList = hibernateTemplate.execute(new HibernateCallback<List<Student>>() {

			@Override
			public List<Student> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Student where rollno = ?");
				q.setInteger(0, rollno);
				List<Student> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
		return stuList;
	}

	@Override
	public void updateStudent(Student student) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				//Student st = (Student)session.get(Student.class,student.getRollno());
				//st.setDate(student.getDate());
				//st.setBreakfast(student.getBreakfast());
				//st.setLunch(student.getLunch());
				//st.setDinner(student.getDinner());
				//session.clear();
				session.update(student);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		
		});
		
	}

	@Override
	public Student selectStudente(int sid) {
		Student student = hibernateTemplate.execute(new HibernateCallback<Student>() {

			@Override
			public Student doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Student st = (Student)session.get(Student.class, sid);
				tr.commit();
				session.flush();
				session.close();
				return st;
			}
		});
		return student;
	}

	
	@Override
	public void deleteStudent(int sid) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Student(sid));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}
	
	
	}
	



