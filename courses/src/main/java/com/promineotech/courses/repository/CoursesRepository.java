package com.promineotech.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineotech.courses.entity.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {

}
