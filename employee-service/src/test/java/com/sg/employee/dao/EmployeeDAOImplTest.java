/**
 * The test class for EmployeeDAOImpl
 */
package com.sg.employee.dao;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.employee.dao.EmployeeDAOImpl;
import com.sg.employee.dao.IEmployeeDAO;
import com.sg.employee.exception.DAOException;
import com.sg.employee.model.Employee;

/**
 * @author Manju Kumar Mohan
 *
 */
@RunWith ( SpringRunner.class )
public class EmployeeDAOImplTest {

	@TestConfiguration
	static class EmployeeDAOImplTestContextConfiguration {
		@Bean
		public IEmployeeDAO employeeDAO() {
			return new EmployeeDAOImpl();
		}
	}

	@Autowired
	private IEmployeeDAO employeeDAOImpl;

	@Test
	public void testSaveEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("TEST");
		employee.setLastName("TEST");
		employee.setDepartment("TEST");
		try {
			employeeDAOImpl.saveEmployee(employee);
		} catch (DAOException e) {
			fail("Failed to save employee");
		}
		employeeDAOImpl.deleteEmployee(employee);
	}

	@Test()
	public void testSaveEmployeeDuplicateEntry() {
		Employee employee = new Employee();
		employee.setFirstName("TEST");
		employee.setLastName("TEST");
		employee.setDepartment("TEST");
		try {
			employeeDAOImpl.saveEmployee(employee);
		} catch (DAOException e) {
			fail("Failed to save employee");
		}
		Employee employee1 = new Employee();
		employee1.setFirstName("TEST");
		employee1.setLastName("TEST");
		employee1.setDepartment("TEST");
		try {
			employeeDAOImpl.saveEmployee(employee1);
			fail("Exception should be raised as employee already exist");
		} catch (DAOException e) {

		}
		employeeDAOImpl.deleteEmployee(employee);
	}

	@Test
	public void testSaveEmployeeNullOrEmptyFirstName() {
		Employee employee = new Employee();
		employee.setFirstName(null);
		employee.setLastName("TEST");
		employee.setDepartment("TEST");
		try {
			employeeDAOImpl.saveEmployee(employee);
		} catch (DAOException e) {
			Assert.assertTrue(e instanceof DAOException);
		}
	}

	@Test
	public void testSaveEmployeeNullorEmptyLastName() {
		Employee employee = new Employee();
		employee.setFirstName("TEST");
		employee.setLastName(null);
		employee.setDepartment("TEST");
		try {
			employeeDAOImpl.saveEmployee(employee);
		} catch (DAOException e) {
			Assert.assertTrue(e instanceof DAOException);
		}
	}

	@Test
	public void testSaveEmployeeNullorEmptyDepartment() {
		Employee employee = new Employee();
		employee.setFirstName("TEST");
		employee.setLastName("TEST");
		employee.setDepartment(null);
		try {
			employeeDAOImpl.saveEmployee(employee);
		} catch (DAOException e) {
			Assert.assertTrue(e instanceof DAOException);
		}
	}

	@Test
	public void testGetEmployees() {
		Employee employee = new Employee();
		employee.setFirstName("TEST");
		employee.setLastName("TEST");
		employee.setDepartment("TEST");
		try {
			employeeDAOImpl.saveEmployee(employee);
		} catch (DAOException e) {
			fail("Failed to save employee");
		}
		Assert.assertNotNull(employeeDAOImpl.getEmployees());
		Assert.assertEquals(1, employeeDAOImpl.getEmployees().size());
		employeeDAOImpl.deleteEmployee(employee);
	}
}
