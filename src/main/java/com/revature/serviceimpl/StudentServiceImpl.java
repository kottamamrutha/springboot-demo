package com.revature.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dto.StudentDto;
import com.revature.entity.Student;
import com.revature.exceptionhandling.UserNotFound;
import com.revature.repository.StudentRepository;
import com.revature.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	public StudentRepository studentRepo;
	
	@Autowired
	public ModelMapper modelMapper;
	@Override
	public StudentDto createStudent(StudentDto sDto) {
		Student s=studentRepo.save(modelMapper.map(sDto, Student.class));
		s.setId(sDto.getId());
		s.setName(sDto.getName());
		s.setBranch(sDto.getBranch());
		return modelMapper.map(s, StudentDto.class);
	}

	@Override
	public List<StudentDto> showStudents() {
		List<Student> s=studentRepo.findAll();
		return s.stream().map(st->modelMapper.map(st, StudentDto.class)).collect(Collectors.toList());
	}

	@Override
	public StudentDto updateById(StudentDto sDto,int id) {
			Student s=studentRepo.findById(id).orElseThrow(
			() -> new UserNotFound(String.format("Student Id is not present",id)) );
			s.setName(sDto.getName());
			s.setBranch(sDto.getBranch());
			studentRepo.save(s);
			return modelMapper.map(s, StudentDto.class);
		
	}

	@Override
	public String deleteById(int id) {		
		return "deleted";
	}

}
