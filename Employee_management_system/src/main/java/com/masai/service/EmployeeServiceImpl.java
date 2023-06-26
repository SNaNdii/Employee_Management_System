package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.EmployeeException;
import com.masai.model.CurrentEmployeeUserSession;
import com.masai.model.Employee;
import com.masai.repository.EmpRepo;
import com.masai.repository.EmpSessionRepo;

import antlr.collections.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmpRepo employeeRepo;
	@Autowired
	private EmpSessionRepo empSessionRepo;
	
	
	@Override
	public Employee addEmployee(Employee e) throws EmployeeException {
		// TODO Auto-generated method stub
			Employee c=employeeRepo.findByEmail(e.getEmail());
			
			if(c!=null)
			{
				throw new EmployeeException("Employee already Exist with this email");
			}
			
			if(e.getPassword().equals(e.getConfirmPassword()))
			{
				return employeeRepo.save(e);
			}
			else
			{
				throw new EmployeeException("Password and Confirm Password did not matched");
			}
	}

	
	
	@Override
	public Employee updateEmployee(Employee e, String key) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee c=employeeRepo.findByEmail(e.getEmail());
		
		if(c==null)
		{
			throw new EmployeeException("Please enter a valid email id");
		}
		
		  CurrentEmployeeUserSession cus= empSessionRepo.findByUuid(key);
		  
		  if(cus==null)
		  {
			  throw new EmployeeException("Please login first as an customer");
		  }
		  
		  Employee ct=employeeRepo.save(e);
		  
		return ct;
	}
	
	

	@Override
	public String removeEmployee(String email, String key) throws EmployeeException {
		// TODO Auto-generated method stub
		CurrentEmployeeUserSession aus= empSessionRepo.findByUuid(key);
		  
		  if(aus==null)
		  {
			  throw new EmployeeException("No Admin Found With This Key");  
		  }
		  
		  
		  Employee c=employeeRepo.findByEmail(email);
			
			if(c==null)
			{
				throw new EmployeeException("Customer does not exist");
			}
		  
		  
			employeeRepo.delete(c);
		   
		   return "Deleted....";
	}

	
	
	
	@Override
	public Employee viewEmployee(String email, String key) throws EmployeeException {
		// TODO Auto-generated method stub
		CurrentEmployeeUserSession aus= empSessionRepo.findByUuid(key);
		  
		  if(aus==null)
		  {
			  throw new EmployeeException("No Admin Found With This Key");  
		  }
		  
		  Employee c=employeeRepo.findByEmail(email);
			
			if(c==null)
			{
				throw new EmployeeException("Customer does not exist");
			}
			
			
			return  c;
	}
	
	

	@Override
	public List viewEmployeeList(String key) throws EmployeeException {
		// TODO Auto-generated method stub
		CurrentEmployeeUserSession aus= empSessionRepo.findByUuid(key);
		  
		  if(aus==null)
		  {
			  throw new EmployeeException("No Admin Found With This Key");  
		  }
		  
		    List<Employee> arr=employeeRepo.findAll();
		  
		    
		    return arr;
	}

}
