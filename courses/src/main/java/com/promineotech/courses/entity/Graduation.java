package com.promineotech.courses.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity

//if the table below does not work recheck the name. The table in Dbeaver is students..
@Table(name="graduation")
public class Graduation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int graduation_id;
	
	@Column(value="student_id")
	private int student_id;
	
	@Column(value="graduation_date")
	private String graduation_date;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
	@JsonIgnore
	private Student students;
	//private List<Student> student;
	
	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
