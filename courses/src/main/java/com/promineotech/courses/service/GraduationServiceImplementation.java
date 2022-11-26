package com.promineotech.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.courses.entity.Graduation;
import com.promineotech.courses.exception.ResourceNotFoundException;
import com.promineotech.courses.repository.GraduationRepository;

@Service
public class GraduationServiceImplementation implements GraduationService{

	private GraduationRepository graduationRepository;
	
	@Autowired
	public GraduationServiceImplementation(GraduationRepository graduationRepository) {
		this.graduationRepository = graduationRepository;
	}

	//Posting a graduation date
	@Override
	public Graduation saveGraduation(Graduation graduation) {
		// TODO Auto-generated method stub
		return graduationRepository.save(graduation);
	}

	//READ all Graduation dates
	@Override
	public List<Graduation> getAllGraduation() {
		
		return graduationRepository.findAll();
	}

	//READ Graduation date by ID
	@Override
	public Graduation getGraduationById(int id) {
		
		return graduationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Graduation", "Id", id));
	}
	
	@Override
	public Graduation updateGraduation1(Graduation graduation, int id) throws ResourceNotFoundException {
		Graduation graduation1 = graduationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Graduation", "Id", id));
		graduation1.setGraduation_id(graduation1.getGraduation_id());
		graduation1.setStudent_id(graduation1.getStudent_id());
		graduation1.setGraduation_date(graduation1.getGraduation_date());
		graduationRepository.save(graduation1);
	   return graduation1;
	}

	
	//DELETE a Graduation date
	@Override
	public void deleteGraduation(int Id) {
		// TODO Auto-generated method stub
		Graduation existingGraduation = graduationRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Graduation", "Id", Id));
		graduationRepository.deleteById(Id);
		
	}

	

	

	
	
}
