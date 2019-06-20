/**
 * The data access layer implementation class for handling CURD for Employee
 */
package com.sg.employee.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.sg.employee.exception.DAOException;
import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;

/**
 * @author Manju Kumar Mohan
 */
@Component
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final Map<String, Employee> employeesDB = new HashMap<>();

	@Override
	public void saveEmployee(Employee employee) throws DAOException {
		String uniqueKey = constructUniqueKey(employee);
		if (employeesDB.containsKey(uniqueKey)) {
			throw new DAOException("Employee already exist in system.");
		}
		long id = Math.abs(generateID());
		employee.setId(id);
		employeesDB.put(uniqueKey, employee);

	}

	@Override
	public Employees getEmployees() {
		return new Employees(employeesDB.values());
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		String uniqueKey = constructUniqueKey(employee);
		return null != employeesDB.remove(uniqueKey);
	}

	private String constructUniqueKey(Employee employee) {

		return employee.getFirstName() + "_" + employee.getLastName() + "_" + employee.getDepartment();
	}

	private long generateID() {
		Random rand = new Random();
		return rand.nextLong();
	}

}
