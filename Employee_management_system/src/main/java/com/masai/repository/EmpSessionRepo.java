package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.model.CurrentEmployeeUserSession;

public interface EmpSessionRepo extends JpaRepository<CurrentEmployeeUserSession,Integer> {
	public CurrentEmployeeUserSession findByUuid(String key);
}
