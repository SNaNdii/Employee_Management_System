package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {
	public Employee findByEmail(String email);
}
