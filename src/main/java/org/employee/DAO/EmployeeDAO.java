package org.employee.DAO;

import java.util.List;
import java.util.Optional;

import org.employee.model.EmployeeDetails;
import org.employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	@Autowired
	EmployeeRepository empRepo;
	

	public EmployeeDetails insertingEmployeeDetails(EmployeeDetails empDetails) {
		System.out.println("dao");
		 return empRepo.save(empDetails);
		
		
		
	}


	public List<EmployeeDetails> gettingAllEmployees() {
		return empRepo.findAll();
	}


	public Optional<EmployeeDetails> gettingDetailsBasedOnPrimaryKey(String email) {
		Optional<EmployeeDetails> one=empRepo.findById(email);
		return one;
		
		
	}


	public EmployeeDetails checkingEmail(String email) {
		//System.out.println(empDetails.getEmail());
		//return empRepo.findById(email).get();
		Optional<EmployeeDetails>one=empRepo.findById(email);
		if(one.isPresent()) {
			return one.get();
		}
		else {
			return null;//e line important
			
		}
		
	}

}
