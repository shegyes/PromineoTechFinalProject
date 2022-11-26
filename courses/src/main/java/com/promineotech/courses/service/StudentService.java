package com.promineotech.courses.service;

import java.util.List;

import com.promineotech.courses.entity.Student;



public interface StudentService {

	
	//Post a student (CREATE)
	public Student saveStudent(Student student);
	
	
	//READ all students
	public List<Student> getAllStudents();
	
	//get a student by an attribute
	public Student getStudentById(int Id);
	
	//the UPDATE
	public Student updateStudent(Student student, int Id);		
	
	//THE DELETE
	public void deleteStudent(int Id);


	public Object findById(int student_id);


	public Student save(Student student);
	

	
}
