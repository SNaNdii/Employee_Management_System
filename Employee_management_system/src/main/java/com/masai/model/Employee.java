package com.masai.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @Column(name = "mobile")
	    private String mobile;

	    private String email;

	    private String address;

	    private String education;

	    @Column(name = "experience_years")
	    private int experienceYears;
}
