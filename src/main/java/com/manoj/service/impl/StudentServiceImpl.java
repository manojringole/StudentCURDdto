package com.manoj.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.dto.StudentDto;
import com.manoj.exception.ResourceNotFoundException;
import com.manoj.model.Student;
import com.manoj.repository.StudentRepo;
import com.manoj.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public StudentDto create(StudentDto dto) {
		
		Student student = this.mapper.map(dto, Student.class);
		Student save = this.repo.save(student);
		
		return this.mapper.map(save, StudentDto.class);
	}

	@Override
	public StudentDto update(StudentDto dto, Integer id) {
		
		Student student = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("invalid Id"+id));
		
		student.setName(dto.getName());
		student.setAddress(dto.getAddress());
		student.setActive(dto.isActive());
		student.setCreated(dto.getCreated());
	
		Student save = this.repo.save(student);
		return this.mapper.map(save, StudentDto.class);
	}

	@Override
	public StudentDto getStudent(Integer id) {
		
		Student student = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("invalid Student Id"+id));
		return this.mapper.map(student, StudentDto.class);
	}

	@Override
	public List<StudentDto> allStrudent() {
		
		List<Student> all = this.repo.findAll();
		
		 List<StudentDto> list = all.stream().map(student -> this.mapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return list;
		
	}

	@Override
	public void delete(Integer id) {
		
		Student student = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("InvaliD Id "+id));
		
		this.repo.delete(student);
	}

}

