package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.Service.StudentService;
import com.cdac.dto.Admin;
import com.cdac.dto.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/prep_student_add_form.htm",method = RequestMethod.GET)
	public String prepStudentAddForm(ModelMap map) {
		map.put("student", new Student());
		return "student_add_form";
		
	}
	
	@RequestMapping(value = "/student_add.htm",method = RequestMethod.POST)
	public String studentAdd(Student student,HttpSession session) {
		int rollno =0;
		if((Admin)session.getAttribute("admin") != null) {
		rollno = ((Admin)session.getAttribute("admin")).getRollno();
		student.setRollno(rollno);
		System.out.println(rollno);
		studentService.addStudent(student);
		}
		return "home";
		
	}
	
	@RequestMapping(value = "/student_list.htm",method = RequestMethod.GET)
	public String allStudents(ModelMap map,HttpSession session) {
		int rollno=0;
		if((Admin)session.getAttribute("admin") != null) {
		rollno = ((Admin)session.getAttribute("admin")).getRollno();
		System.out.println(rollno);
		List<Student> li = studentService.selectAll(rollno);
		map.put("stuList", li);
		System.out.println(li);
		}
		return "student_list";
	}
	
	@RequestMapping(value = "/student_update_form.htm",method = RequestMethod.GET)
	public String expenseUpdateForm(@RequestParam int sid,ModelMap map) {
		
		Student stu = studentService.findStudente(sid);
		map.put("student", stu);
		
		return "student_update_form";
	}
	
	@RequestMapping(value = "/student_update.htm",method = RequestMethod.POST)
	public String studentUpdate(Student student,ModelMap map,HttpSession session) {
		
		int rollno = ((Admin)session.getAttribute("admin")).getRollno();
		student.setRollno(rollno);
		studentService.modifyStudent(student);
			
		List<Student> li = studentService.selectAll(rollno);
		map.put("stuList", li);
		System.out.println(li);
		return "student_list";
	}
	@RequestMapping(value = "/student_delete.htm",method = RequestMethod.GET)
	public String studentDelete(@RequestParam int sid,ModelMap map,HttpSession session) {
		
		studentService.removeStudent(sid); 
		int rollno = ((Admin)session.getAttribute("admin")).getRollno();
		List<Student> li = studentService.selectAll(rollno);
		map.put("stuList", li);
		return "student_list";
	}
}
