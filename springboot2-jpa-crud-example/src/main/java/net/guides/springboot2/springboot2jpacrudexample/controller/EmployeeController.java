package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

//import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.model.EmployeeDetails;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeDetailsRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4300")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	Employee emply;
	
	@Autowired
	EmployeeDetails empDetils;
	
	@Autowired
	EmployeeDetailsRepository empDetilsRepo;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

//	@PostMapping("/employees")
//	public Employee createEmployee( @RequestBody Employee employee) {
//		
//		System.out.println("Quantity"+employee.getQuantity()+""+employee.getPrice());
//		Employee emply = new Employee(); // Initialize emply
//	    EmployeeDetails empDetils = new EmployeeDetails(); 
//		
//		 int  quantity = employee.getQuantity(); 
//		int price =  employee.getPrice();
//		int total = quantity+price;
//		emply.setItemName(employee.getItemName());
//		emply.setQuantity(employee.getQuantity());
//		emply.setPrice(employee.getPrice());
//		emply.setEmailId(employee.getEmailId());
//		
//		empDetils = employee.getEmpDetils();
//		
//		empDetilsRepo.save(empDetils);
//		
//		
//		 
//		emply.setTotal(total);
//		emply.setEmpDetils(empDetils);
//		
//		
//		
//		return employeeRepository.save(emply);
//	}
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
	    try {
	        if (employee == null) {
	            throw new IllegalArgumentException("Employee data is null");
	        }

	        Employee emply = new Employee();
	        EmployeeDetails empDetils = new EmployeeDetails();

	        System.out.println("Quantity: " + employee.getQuantity() + ", Price: " + employee.getPrice());

	        int quantity = employee.getQuantity();
	        int price = employee.getPrice();
	        int total = quantity + price;

	        emply.setItemName(employee.getItemName());
	        emply.setQuantity(employee.getQuantity());
	        emply.setPrice(employee.getPrice());
	        emply.setEmailId(employee.getEmailId());

	        empDetils = employee.getEmpDetils();
	        if (empDetils != null) {
	            empDetilsRepo.save(empDetils);
	            emply.setEmpDetils(empDetils);
	        }

	        emply.setTotal(total);

	        return employeeRepository.save(emply);
	    } catch (Exception e) {
	        // Log the exception or handle it accordingly
	        System.err.println("Error creating employee: " + e.getMessage());
	        throw e; // Propagate the exception for proper handling at the higher level
	    }
	}


	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			 @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setItemName(employeeDetails.getItemName());
		employee.setQuantity(employeeDetails.getQuantity());
		employee.setPrice(employeeDetails.getPrice());
		employee.setTotal(employeeDetails.getTotal());
		
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
}
