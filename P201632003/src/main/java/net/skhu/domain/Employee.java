package net.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String company;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="email_address")
	String emailAddress;
	
	@Column(name="job_title")
	String jobTitle;
	
	@Column(name="business_phone")
	String businessPhone;
		
	String city;
}
