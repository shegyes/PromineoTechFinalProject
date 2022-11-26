package com.promineotech.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineotech.courses.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
