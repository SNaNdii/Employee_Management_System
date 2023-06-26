package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exceptions.EmployeeException;
import com.masai.model.Employee;
import antlr.collections.List;


@Service
public interface EmployeeService {

	public  Employee addEmployee(Employee e) throws EmployeeException;
    
    public  Employee updateEmployee(Employee e, String key) throws EmployeeException;
    
    public  String removeEmployee(String email, String key) throws EmployeeException;
    
    public  Employee viewEmployee(String email, String key) throws EmployeeException;
    
    public  List viewEmployeeList(String key) throws EmployeeException;
   
}
