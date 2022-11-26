package com.promineotech.courses.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity

//if the table below does not work recheck the name. The table in Dbeaver is students..
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
		
	@Column(value="first_name")
	private String first_name;
	
	@Column(value="last_name")
	private String last_name;

	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinTable(name = "students_courses",joinColumns = @JoinColumn( name = "student_id",referencedColumnName = "student_id"),
	inverseJoinColumns = @JoinColumn( name = "course_id", referencedColumnName = "course_id")
	)
	@JsonIgnore
	private Set<Courses> courses = new HashSet<>();
	
	@OneToMany(mappedBy = "student_id")
	@JsonIgnore
	private Set<Graduation> graduation_id;
	
	
	
	
			
}
