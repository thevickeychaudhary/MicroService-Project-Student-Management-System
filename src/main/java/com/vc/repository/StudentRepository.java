package com.vc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vc.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByName(String name);

	
}
