package com.manoj.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {

    private Integer id;
	
	private String name;
	
	private String address;
	
	private Date created;
	
	private boolean active;

}
