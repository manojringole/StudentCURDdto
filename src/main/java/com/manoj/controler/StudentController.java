package com.manoj.controler;

import java.util.Date;
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

import com.manoj.dto.StudentDto;
import com.manoj.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto dto){
		
		dto.setActive(true);
		dto.setCreated(new Date());
		
		StudentDto create = service.create(dto);
		return new ResponseEntity<StudentDto>(create, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDto> update(@RequestBody StudentDto dto, @PathVariable Integer id){
	
		dto.setActive(true);
		dto.setCreated(new Date());
		
		StudentDto update = service.update(dto, id);
		return new ResponseEntity<StudentDto>(update,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable Integer id){
		
		StudentDto student = service.getStudent(id);
		return new ResponseEntity<StudentDto>(student,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> AllStudent(){
		
		List<StudentDto> student = service.allStrudent();
		return new ResponseEntity<List<StudentDto>>(student, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		
		service.delete(id);
		
		return new ResponseEntity<String>("deleted Successfully" ,HttpStatus.OK);
	}
	
}
