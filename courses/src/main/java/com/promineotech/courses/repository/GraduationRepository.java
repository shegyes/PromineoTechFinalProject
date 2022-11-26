package com.promineotech.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineotech.courses.entity.Graduation;

@Repository
public interface GraduationRepository extends JpaRepository<Graduation,Integer> {

}
