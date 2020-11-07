package com.cdac.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.StudentDao;
import com.cdac.dto.Student;


@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	

	@Override
	public void addStudent(Student student) {
		studentDao.insertStudent(student);
		
	}

	@Override
	public List<Student> selectAll(int rollno) {
		return studentDao.selectAll(rollno);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDao.updateStudent(student);
		
	}

	@Override
	public Student findStudente(int sid) {
		return studentDao.selectStudente(sid);
	}

	@Override
	public void removeStudent(int sid) {
		studentDao.deleteStudent(sid);
		
	}

}
