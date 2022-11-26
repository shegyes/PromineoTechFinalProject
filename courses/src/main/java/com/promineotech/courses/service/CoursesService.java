package com.promineotech.courses.service;

import java.util.List;

import com.promineotech.courses.entity.Courses;



public interface CoursesService {

	//Post a student (CREATE)
		public Courses saveCourses(Courses courses);
		
		
		//READ all students
		public List<Courses> getAllCourses();
		
		//get a student by an attribute
		public Courses getCoursesById(int Id);
		
		//the UPDATE
		public Courses updateCourses(Courses courses, int Id);		
		
		//THE DELETE
		public void deleteCourses(int Id);


		public Object findById(int course_id);


		public Courses save(Courses courses);
	
}
