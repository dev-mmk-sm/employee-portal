package com.sg.employee.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sg.employee.exception.EmployeeAlreadyExistException;
import com.sg.employee.exception.InvalidUserInputException;
import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;
import com.sg.employee.service.IEmployeeService;

import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(value = "*")
public class EmployeeApiController implements EmployeeApi {

	@Autowired
	private IEmployeeService employeeService;

	private static final Logger log = LoggerFactory.getLogger(EmployeeApiController.class);

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> saveEmployee(
			@ApiParam(value = "The employee to create.") @Valid @RequestBody Employee employee) {
		try {
			employeeService.saveEmployee(employee);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (InvalidUserInputException e) {
			log.error("Failed to save employee", e);
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		} catch (EmployeeAlreadyExistException e) {
			log.error("Failed to save employee", e);
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<Employees> getEmployees() {
		return ResponseEntity.ok(employeeService.getEmployees());
	}

}
