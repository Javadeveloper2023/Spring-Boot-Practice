package com.springboot.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practice.service.SampleService;
import com.springboot.practice.vo.EmployeeVO;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	SampleService sampleService;

	@GetMapping("/test")
	public String sayHi() {
		return "Hi, ";
	}

	@GetMapping("/hi/{name}")
	public String sayHi(@PathVariable("name") String name) {
		return "Hi, " + name;
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam("firstname") String name, @RequestParam("lastname") String last) {
		return "Hello " + name + ", " + last;
	}

	@PostMapping(value = "/printEmpInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String printEmpInfo(@RequestBody EmployeeVO vo) {
		return sampleService.printEmpInfo(vo);
	}

	@PostMapping(value = "/saveOrUpdateEmpInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeVO saveOrUpdateEmpInfo(@RequestBody EmployeeVO vo) {
		return sampleService.saveOrUpdateEmpInfo(vo);
	}

	@DeleteMapping(value = "/delete/{empId}")
	public String deleteEmployee(@PathVariable(name = "empId") Long empId) {
		return sampleService.deleteEmployee(empId);
	}

}
