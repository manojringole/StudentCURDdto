package com.manoj.service;

import java.util.List;

import com.manoj.dto.StudentDto;

public interface StudentService {

	public StudentDto create(StudentDto dto);
	
	public StudentDto update(StudentDto dto , Integer id);
	
	public StudentDto getStudent(Integer id);
	
	public List<StudentDto> allStrudent();
	
	public void delete(Integer id);
}
