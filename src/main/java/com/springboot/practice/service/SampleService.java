package com.springboot.practice.service;

import org.springframework.stereotype.Service;

import com.springboot.practice.vo.EmployeeVO;

@Service
public class SampleService {

	public String printEmpInfo(EmployeeVO vo) {
		System.out.println(vo.toString());
		return "Success";
	}

	
}
