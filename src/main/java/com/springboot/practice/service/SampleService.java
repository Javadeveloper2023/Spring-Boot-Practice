package com.springboot.practice.service;

import java.util.Optional;

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

	public EmployeeVO saveOrUpdateEmpInfo(EmployeeVO vo) {
		Employee emp = new Employee();
		if (vo.getEmpId() != 0) {
			emp = employeeRepository.getById(Long.valueOf(vo.getEmpId()));
		}
		BeanUtils.copyProperties(vo, emp);
		employeeRepository.save(emp);
		BeanUtils.copyProperties(emp, vo);
		vo.setEmpId(emp.getId().intValue());
		return vo;
	}

	public String deleteEmployee(Long empId) {
		Optional<Employee> empOpt = employeeRepository.findById(empId);
		if (!empOpt.isPresent()) {
			return "Failed";
		}
		employeeRepository.delete(empOpt.get());
		return "Success";
	}

}
