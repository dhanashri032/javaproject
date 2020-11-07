package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Student;

public interface StudentDao {
	
	void insertStudent(Student student);
	List<Student> selectAll(int rollno);
	void updateStudent(Student student);
	Student selectStudente(int sid);
	void deleteStudent(int sid);
}
