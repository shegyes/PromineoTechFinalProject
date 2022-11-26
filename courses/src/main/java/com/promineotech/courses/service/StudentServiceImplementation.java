package com.promineotech.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.courses.entity.Student;
import com.promineotech.courses.exception.ResourceNotFoundException;
import com.promineotech.courses.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImplementation(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	//Posting a Player
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	//READ all students
	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	//READ student by ID
	@Override
	public Student getStudentById(int id) {
		
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
	}

	//UPDATE a student
	@Override
	public Student updateStudent(Student student, int Id) {
		// TODO Auto-generated method stub
		Student existingStudent = studentRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", Id));
		existingStudent.setFirst_name(student.getFirst_name());
		existingStudent.setLast_name(student.getLast_name());
		
		studentRepository.save(existingStudent);
		return existingStudent;
	}

	//DELETE a student
	@Override
	public void deleteStudent(int Id) {
		// TODO Auto-generated method stub
		Student existingStudent = studentRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", Id));
		studentRepository.deleteById(Id);
		
	}

	@Override
	public Object findById(int student_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
}
