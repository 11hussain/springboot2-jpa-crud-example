package net.guides.springboot2.springboot2jpacrudexample.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetails implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String employeeDetails_Id;
	
	private String Street;
	private String State;
	public EmployeeDetails() {
		super();
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getEmployeeDetails_Id() {
		return employeeDetails_Id;
	}
	public void setEmployeeDetails_Id(String employeeDetails_Id) {
		this.employeeDetails_Id = employeeDetails_Id;
	}
	
	
	
	
	
	
	
	



	
	

	
	
	
	
	
	
	
}
