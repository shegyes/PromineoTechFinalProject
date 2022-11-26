package com.promineotech.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.courses.entity.Courses;
import com.promineotech.courses.exception.ResourceNotFoundException;
import com.promineotech.courses.repository.CoursesRepository;

@Service
public class CoursesServiceImplementation implements CoursesService {

	
	private CoursesRepository coursesRepository;
	
	@Autowired
	public CoursesServiceImplementation(CoursesRepository coursesRepository) {
		this.coursesRepository = coursesRepository;
	}

	//Posting a Course
	@Override
	public Courses saveCourses(Courses courses) {
		
		return coursesRepository.save(courses);
	}

	//READ all courses
	@Override
	public List<Courses> getAllCourses() {
		
		return coursesRepository.findAll();
	}

	//READ courses by ID
	@Override
	public Courses getCoursesById(int id) {
		
		return coursesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Courses", "Id", id));
	}

	//UPDATE a course
	@Override
	public Courses updateCourses(Courses courses, int Id) {
		// TODO Auto-generated method stub
		Courses existingCourses = coursesRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Courses", "Id", Id));
		existingCourses.setTitle(courses.getTitle());
				
		coursesRepository.save(existingCourses);
		return existingCourses;
	}

	//DELETE a course
	@Override
	public void deleteCourses(int Id) {
		// TODO Auto-generated method stub
		Courses existingCourses = coursesRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Courses", "Id", Id));
		coursesRepository.deleteById(Id);
		
	}

	@Override
	public Object findById(int course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Courses save(Courses courses) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
