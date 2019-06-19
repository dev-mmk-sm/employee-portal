/**
 * The Employee service implementation class responsible for handling the business logic
 */
package com.sg.employee.service;

import org.springframework.stereotype.Service;

import com.sg.employee.exception.EmployeeAlreadyExistException;
import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;

/**
 * @author Manju Kumar Mohan
 *
 */
@Service
public class EmployeeService implements IEmployeeService {
	@Override
	public void saveEmployee(Employee employee) throws EmployeeAlreadyExistException {
		// TODO Auto-generated method stub

	}

	@Override
	public Employees getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
