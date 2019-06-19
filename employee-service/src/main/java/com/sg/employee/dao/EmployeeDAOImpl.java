/**
 * The data access layer implementation class for handling CURD for Employee
 */
package com.sg.employee.dao;

import org.springframework.stereotype.Component;

import com.sg.employee.exception.DAOException;
import com.sg.employee.exception.EmployeeAlreadyExistException;
import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;

/**
 * @author Manju Kumar Mohan
 *
 */
@Component
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public void saveEmployee(Employee employee) throws EmployeeAlreadyExistException, DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Employees getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
