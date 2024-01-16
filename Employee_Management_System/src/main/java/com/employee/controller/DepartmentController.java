package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.model.Department;
import com.employee.service.DepartmentService;


@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptSer;
	
	@PostMapping("/departments")
	public ResponseEntity<Department>addNewDepartmentHandler(@RequestBody Department d){
		Department newDepartment = deptSer.addNewDepartment(d);
		return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
	}
}
