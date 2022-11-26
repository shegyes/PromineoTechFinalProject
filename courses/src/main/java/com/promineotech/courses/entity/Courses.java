package com.promineotech.courses.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;
	
	@Column(value="student_id")
	private int student_id;
		
	@Column(value="title")
	private String title;


	
	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Student> student;
		
	
	
}
