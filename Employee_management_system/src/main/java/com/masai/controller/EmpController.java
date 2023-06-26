package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exceptions.EmployeeException;
import com.masai.model.Employee;
import com.masai.service.EmployeeService;

@RestController
public class EmpController {

	@Autowired
	private EmployeeService empService;
	
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployeeHandler(@RequestBody Employee employee) throws EmployeeException{
		
		Employee c=empService.addEmployee(employee);
	
		return new ResponseEntity<>(c,HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployeeHandler(@RequestBody Employee employee,@RequestParam String key) throws EmployeeException{
		
		Employee c=empService.updateEmployee(employee, key);
	
		return new ResponseEntity<>(c,HttpStatus.OK);
		
		
	}
	
	
	
	@DeleteMapping("/employee/{email}")
	public ResponseEntity<String> removeEmployeeHandler(@PathVariable String email,@RequestParam String key) throws EmployeeException{
		
		String result=empService.removeEmployee(email, key);
	
		return new ResponseEntity<>(result,HttpStatus.OK);
		
		
	}
	
	
	
	@GetMapping("/employee/{email}")
	public ResponseEntity<Employee> viewEmployeeHandler(@PathVariable String email,@RequestParam String key) throws EmployeeException{
		
		Employee c=empService.viewEmployee(email, key);
	
		return new ResponseEntity<>(c,HttpStatus.OK);
		
		
	}	
	
	
	@GetMapping("employees/")	
    public ResponseEntity<List<Employee>> viewEmployeeListHandler(@RequestParam String key) throws EmployeeException{
		
		List<Employee> arr=(List<Employee>) empService.viewEmployeeList(key);
	
		return new ResponseEntity<>(arr,HttpStatus.OK);
		
		
	}
}
