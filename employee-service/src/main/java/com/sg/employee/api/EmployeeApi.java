/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.5).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.sg.employee.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;
import com.sg.employee.model.Error;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-19T05:35:08.152Z")

@Api(value = "employee", description = "the employee API")
public interface EmployeeApi {

    @ApiOperation(value = "Registers an employee information", nickname = "saveEmployee", notes = "Registers an employee information", response = Employee.class, tags={ "Employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Queried successfully", response = Employee.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 503, message = "Service is unavailable", response = Error.class) })
    @RequestMapping(value = "/employee",
        method = RequestMethod.POST)
    ResponseEntity<HttpStatus> saveEmployee(@ApiParam(value = "The employee to create."  )  @Valid @RequestBody Employee employee);
    
    @ApiOperation(value = "Retrieves all employees", nickname = "getEmployees", notes = "Retrieves all employees", response = Employees.class, tags={ "Employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Queried successfully", response = Employees.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 503, message = "Service is unavailable", response = Error.class) })
    @RequestMapping(value = "/employees",
        method = RequestMethod.GET)
    ResponseEntity<Employees> getEmployees();

}