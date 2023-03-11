package com.manoj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manoj.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
