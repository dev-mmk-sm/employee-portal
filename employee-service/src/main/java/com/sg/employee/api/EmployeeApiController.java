package com.sg.employee.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-19T05:35:08.152Z")

@Controller
public class EmployeeApiController implements EmployeeApi {

	private static final Logger log = LoggerFactory.getLogger(EmployeeApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public EmployeeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Employee> saveEmployee(
			@ApiParam(value = "The employee to create.") @Valid @RequestBody Employee employee) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Employee>(objectMapper.readValue(
						"{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"gender\" : \"gender\",  \"dob\" : \"dob\",  \"id\" : 0,  \"department\" : \"department\"}",
						Employee.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Employees> getEmployees() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Employees>(objectMapper.readValue("\"\"", Employees.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Employees>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Employees>(HttpStatus.NOT_IMPLEMENTED);
	}

}
