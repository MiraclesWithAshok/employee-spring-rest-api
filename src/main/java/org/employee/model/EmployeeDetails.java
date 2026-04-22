package org.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDetails {

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Integer Id;
	@Id
	
	private String email;
	private String employeeName;
	private String dept;
	private Long salary;

}
