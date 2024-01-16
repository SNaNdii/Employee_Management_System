package com.employee.model;

import java.util.Date;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String empName;
	private String email;
	private Integer salary;
	private Date joiningDate;
	@Enumerated
	private Gender gender;
	@Embedded
	private Address address;
	@ManyToOne
	private Department dept;
}
