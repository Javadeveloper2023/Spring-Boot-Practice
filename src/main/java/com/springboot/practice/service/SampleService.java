package com.springboot.practice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practice.entity.Employee;
import com.springboot.practice.repository.EmployeeRepository;
import com.springboot.practice.vo.EmployeeVO;

@Service
public class SampleService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public String printEmpInfo(EmployeeVO vo) {
		System.out.println(vo.toString());
		return "Success";
	}

	public String saveOrUpdateEmpInfo(EmployeeVO vo) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(vo, emp);
		employeeRepository.save(emp);
		return "Success";
	}

	
}
