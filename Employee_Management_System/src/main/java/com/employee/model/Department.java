package com.employee.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptId;
	private String deptName;
	
	@OneToMany(mappedBy = "dept" , cascade = CascadeType.ALL)
	private List<Employee>employees = new ArrayList<>();
}
