/**
 * Test class for EmployeeAPIController
 */
package com.sg.employee.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;

/**
 * @author Manju Kumar Mohan
 *
 */
public class EmployeeApiControllerTest extends AbstractSetupTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void addEmployee() throws Exception {
		String uri = "/employee";
		Employee employee = new Employee();
		employee.setFirstName("Test");
		employee.setLastName("Another");
		employee.setDepartment("CSE");
		employee.setDob("15-02-1989");
		employee.setGender("Male");

		String inputJson = super.mapToJson(employee);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
	}

	@Test
	public void getEmployees() throws Exception {
		String uri = "/employees";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Employees employees = super.mapFromJson(content, Employees.class);
		assertTrue(employees.size() > 0);
	}
}
