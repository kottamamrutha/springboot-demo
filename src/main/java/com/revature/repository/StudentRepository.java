package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.revature.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
