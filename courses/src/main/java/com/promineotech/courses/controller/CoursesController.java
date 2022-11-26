package com.promineotech.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.courses.entity.Courses;
import com.promineotech.courses.service.CoursesService;

@RestController
@RequestMapping("/courses/courses")
public class CoursesController {

	@Autowired
	private CoursesService coursesService;
	
	
	
	public CoursesController(CoursesService coursesService) {
		super();
		this.coursesService = coursesService;
	}
	
	
	//create Student API
	@PostMapping()
	public ResponseEntity<Courses> saveCourses(@RequestBody Courses courses) {
		return new ResponseEntity<Courses>(coursesService.saveCourses(courses), HttpStatus.CREATED);
	}
	
	//Read all mapping
	@GetMapping
	public List<Courses> getAllCourses() {
		return coursesService.getAllCourses();
	}
	
	//Read by ID
	@GetMapping("{course_id}")
	public ResponseEntity<Courses> getCoursesById(@PathVariable("course_id") int coursesId) {
		return new ResponseEntity<Courses>(coursesService.getCoursesById(coursesId), HttpStatus.OK);
	}
	
	//UPDATE student
	@PutMapping("{course_id}")
	public ResponseEntity<Courses> updateCourses(@PathVariable("course_id") int coursesId, @RequestBody Courses courses) {
		return new ResponseEntity<Courses>(coursesService.updateCourses(courses, coursesId), HttpStatus.OK);
	}
	
		
	//DELETE Student
	@DeleteMapping("{course_id}")
	public ResponseEntity<String> deleteCourses(@PathVariable("course_id") int coursesId) {
		coursesService.deleteCourses(coursesId);
		return new ResponseEntity<String>("That Course has been deleted.", HttpStatus.OK);
	}
	
	
}
