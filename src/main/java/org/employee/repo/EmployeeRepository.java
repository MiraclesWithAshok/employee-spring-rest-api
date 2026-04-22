package org.employee.repo;

import org.employee.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails,String> {
    //@Query("select employee from EmployeeDetails employee where employee.employeeName=?1")
//	List<EmployeeDetails>getByEmployeeName();
	
	@Query("select employee from EmployeeDetails employee where employee.employeeName=?1 Or employee.dept=?1")
	List<EmployeeDetails>getByEmployeeNameOrDept(String variable);

}
