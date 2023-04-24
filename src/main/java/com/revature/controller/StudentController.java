package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.StudentDto;
import com.revature.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<StudentDto>studentCreatetion(@RequestBody StudentDto sDto){
		return new ResponseEntity<>(studentService.createStudent(sDto),HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentDto>> showStudents(){
		return new ResponseEntity<>(studentService.showStudents(),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<StudentDto> updatedById(@RequestBody StudentDto sDto,@PathVariable int id){
		return new ResponseEntity<>(studentService.updateById(sDto,id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deletedById(@PathVariable int id){
		return new ResponseEntity<>(studentService.deleteById(id),HttpStatus.ACCEPTED);
	}
}
