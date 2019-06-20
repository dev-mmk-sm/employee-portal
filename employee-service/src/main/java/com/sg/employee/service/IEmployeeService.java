/**
 * The Employee service interface responsible for handling the business logic
 */
package com.sg.employee.service;

import com.sg.employee.exception.EmployeeAlreadyExistException;
import com.sg.employee.exception.InvalidUserInputException;
import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;

/**
 * @author Manju Kumar Mohan
 *
 */
public interface IEmployeeService {
	
	void saveEmployee(Employee employee) throws EmployeeAlreadyExistException,InvalidUserInputException;
	
	Employees getEmployees();
	
	boolean deleteEmployee(Employee employee);

}
