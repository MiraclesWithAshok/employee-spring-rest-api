package org.employee.controller;

import java.util.List;
import java.util.Optional;

import org.employee.exception.NoSuchElementException;
import org.employee.model.EmployeeDetails;
import org.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
	@Autowired	
	EmployeeService empService;
//	public EmployeeController(EmployeeService empService) {
//		this.
//	}
	@PostMapping("/reg")
	public ResponseEntity<String> registration(@RequestBody EmployeeDetails empDetails) {
		System.out.println(empDetails.getEmployeeName());
		empService.insertEmployeeDetails(empDetails);
		return ResponseEntity.status(201).body("employee created");
		
	}
	
	@GetMapping("/displayAll")
	public ResponseEntity<List<EmployeeDetails>> displayAllDetails() {
//	List<EmployeeDetails>All=	empService.getAllEmployees();
//		System.out.println(All);
		return ResponseEntity.status(200).body(empService.getAllEmployees());
		
	}
	
	@GetMapping("/getByPrimarykey/{email}")
	public  ResponseEntity<EmployeeDetails> displayDetailsBasedOnPrimaryKey(@PathVariable String email) {
		
		Optional<EmployeeDetails> one=empService.getDetailsBasedOnPrimarykey(email);
			//ekkaada pathvariable aweina use cesukovacchu ledha optional use cesukoni get cesukovacchu..
			if(one.isPresent()) {
				return ResponseEntity.status(200).body(one.get());
			}else {
		//	ResponseEntity.status(404).body(throw NoSuchElementException("email is wrong"));//body only wants value not exception
				throw new NoSuchElementException("please provide correct email");
			}
			
		
		
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody EmployeeDetails empDetails) {
		System.out.println(empDetails);
		boolean status=empService.checkLogining(empDetails);
		if(status) {
			return ResponseEntity.status(200).body("success login");
			
		}
		else {
			return ResponseEntity.status(404).body("login failed please agian login");
		}
		
		
	}
	
	@PutMapping("/update/{email}")
	public ResponseEntity<String> updateEmployeeDetails(@PathVariable String email,@RequestBody EmployeeDetails empDetails) {
		Optional<EmployeeDetails> one=empService.getDetailsBasedOnPrimarykey(email);
		EmployeeDetails getEmpDetails=one.get();
		getEmpDetails.setEmail(empDetails.getEmail());
		getEmpDetails.setEmployeeName(empDetails.getEmployeeName());
		getEmpDetails.setDept(empDetails.getDept());
		getEmpDetails.setSalary(empDetails.getSalary());
		 empService.insertEmployeeDetails(getEmpDetails);
		 return ResponseEntity.status(200).body("updated");
		
		
		
		
		
		
		
	}
	//	@GetMapping("/search/{variable}")
//	public List<EmployeeDetails> displayDetailsBasedOnWithoutPrimarykey(@PathVariable String variable) {
//		
//		List<EmployeeDetails>all =empService.getDetailsBasedOnWithoutPrimarykey(variable);
//		System.out.println(all);
//		return all;
//	}
	@GetMapping("/search/{variable}")
	public List<EmployeeDetails> displayDetailsBasedOnWithoutPrimarykey(@PathVariable String variable) {
		
		List<EmployeeDetails>all =empService.getDetailsBasedOnWithoutPrimarykey(variable);
		System.out.println(all);
		return all;
	}
	//next exception ni postman lo oka format lo manaki nacchinattu cupinchadam yela...
	
	

}
