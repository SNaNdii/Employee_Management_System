package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.model.Department;
import com.employee.repository.DepartmentRepository;



@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public Department addNewDepartment(Department d) {
		Department newDept = deptRepo.save(d);
		// TODO Auto-generated method stub
		return newDept;
	}

}
