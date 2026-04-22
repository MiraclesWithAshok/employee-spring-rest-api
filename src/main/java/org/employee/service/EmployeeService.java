package org.employee.service;

import java.util.List;
import java.util.Optional;

import org.employee.DAO.EmployeeDAO;
import org.employee.model.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDAO empDAO;
	

	public EmployeeDetails insertEmployeeDetails(EmployeeDetails empDetails) {
		System.out.println("service");
		return empDAO.insertingEmployeeDetails(empDetails);
		
		
	}


	public List<EmployeeDetails> getAllEmployees() {
		
		return empDAO.gettingAllEmployees();
	}


	public Optional<EmployeeDetails> getDetailsBasedOnPrimarykey(String email) {
		return empDAO.gettingDetailsBasedOnPrimaryKey(email);
		
	}


	public boolean checkLogining(EmployeeDetails empDetails) {
		EmployeeDetails originalDetails=empDAO.checkingEmail(empDetails.getEmail());
		if(originalDetails==null) {
			return false;
		}//dhini valla use enti ante a if database lo email ledhu anuko null esthundhi so direct ga false thisukuntundhi ...
		//okavela e statment lekapothe a empdetails anedhi null avutunhdij then next nuu empDetails.getDept() ela get cesthe a niku lopala null kabbati nullPointerException vasthundhij ..
		if(originalDetails.getDept().equals(empDetails.getDept())) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

}
