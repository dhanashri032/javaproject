package com.cdac.Service;

import java.util.List;

import com.cdac.dto.Student;

public interface StudentService {

	void addStudent(Student student);
	List<Student> selectAll(int rollno);
	void modifyStudent(Student student);
	Student findStudente(int sid);
	void removeStudent(int sid);
}
