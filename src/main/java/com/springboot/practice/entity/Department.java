package com.springboot.practice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Department {

	@Id
	private Long id;
	
	private String name;
	
	private String deptCode;
	
	
}
