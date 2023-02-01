package com.springboot.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.practice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDeptCode(String deptCode);
}
