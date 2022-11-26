package com.promineotech.courses.service;

import java.util.List;

import com.promineotech.courses.entity.Graduation;
import com.promineotech.courses.exception.ResourceNotFoundException;

/**
 * 
 * @param graduation
 * @param Id
 * @param graduation_id
 * @return
 *
 */

public interface GraduationService {

	//Post a student (CREATE)
		public Graduation saveGraduation(Graduation graduation);
		
		
		//READ all students
		public List<Graduation> getAllGraduation();
		
		//get a student by an attribute
		public Graduation getGraduationById(int Id);
		
		//the UPDATE
		//public Graduation updateGraduation(Graduation graduation, int Id);		
		
		//THE DELETE
		public void deleteGraduation(int Id);


		Graduation updateGraduation1(Graduation graduation, int id) throws ResourceNotFoundException;


		
}
