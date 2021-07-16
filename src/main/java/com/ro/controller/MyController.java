package com.ro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping(value = "/getStudent")
	public Student getStudentInfo() {
		Student student = new Student();
		student.setRonum(11);
		return student;
	}
}
