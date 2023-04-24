package com.revature.service;

import java.util.List;

import com.revature.dto.StudentDto;

public interface StudentService {

	public StudentDto createStudent(StudentDto sDto);
	public List<StudentDto> showStudents(); 
	public StudentDto updateById(StudentDto sDto,int id);
	public String deleteById(int id);
}
