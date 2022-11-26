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

import com.promineotech.courses.entity.Graduation;
import com.promineotech.courses.service.GraduationService;

@RestController
@RequestMapping("/courses/graduation")
public class GraduationController {

	@Autowired
	private GraduationService graduationService;
		
		
		public GraduationController(GraduationService graduationService) {
			super();
			this.graduationService = graduationService;
		}
		
		
		//create Student API
		@PostMapping()
		public ResponseEntity<Graduation> saveGraduation(@RequestBody Graduation graduation) {
			return new ResponseEntity<Graduation>(graduationService.saveGraduation(graduation), HttpStatus.CREATED);
		}
		
		//Read all mapping
		@GetMapping
		public List<Graduation> getAllGraduation() {
			return graduationService.getAllGraduation();
		}
		
		//Read by ID
		@GetMapping("{graduation_id}")
		public ResponseEntity<Graduation> getGraduationById(@PathVariable("graduation_id") int graduationId) {
			return new ResponseEntity<Graduation>(graduationService.getGraduationById(graduationId), HttpStatus.OK);
		}
		
		//UPDATE student
		@PutMapping("{graduation_id}")
		public ResponseEntity<Graduation> updateGraduation1(@PathVariable("graduation_id") int graduationId, @RequestBody Graduation graduation) {
			return new ResponseEntity<Graduation>(graduationService.updateGraduation1(graduation, graduationId), HttpStatus.OK);
		}
		
				
		//DELETE Student
		@DeleteMapping("{graduation_id}")
		public ResponseEntity<String> deleteGraduation(@PathVariable("graduation_id") int graduationId) {
			graduationService.deleteGraduation(graduationId);
			return new ResponseEntity<String>("That Graduation Date has been deleted.", HttpStatus.OK);
		}
	
}
