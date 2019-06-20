/*
 * The data access layer interface for handling CURD for Employee
 */
package com.sg.employee.dao;

import com.sg.employee.exception.DAOException;
import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;

/**
 * @author Manju Kumar Mohan
 *
 */
public interface IEmployeeDAO {

	public void saveEmployee(Employee employee) throws DAOException;

	public Employees getEmployees();
	
	boolean deleteEmployee(Employee employee);
}
