/**
 * The test class for EmployeeService
 */
package com.sg.employee.service;

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
import com.sg.employee.exception.EmployeeAlreadyExistException;
import com.sg.employee.exception.InvalidUserInputException;
import com.sg.employee.model.Employee;

/**
 * @author Manju Kumar Mohan
 */
@RunWith ( SpringRunner.class )
public class EmployeeServiceTest {
    
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public IEmployeeService employeeService() {
            return new EmployeeService();
        }
        
        @Bean
        public IEmployeeDAO employeeServiceDAO() {
            return new EmployeeDAOImpl();
        }
    }
    
    @Autowired
    private IEmployeeService employeeService;
    
    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setFirstName( "TEST" );
        employee.setLastName( "TEST" );
        employee.setDepartment( "TEST" );
        try {
            employeeService.saveEmployee( employee );
        } catch ( EmployeeAlreadyExistException | InvalidUserInputException e ) {
            fail( "Failed to save employee" );
        }
        employeeService.deleteEmployee( employee );
    }

    @Test()
    public void testSaveEmployeeDuplicateEntry() {
        Employee employee = new Employee();
        employee.setFirstName( "TEST" );
        employee.setLastName( "TEST" );
        employee.setDepartment( "TEST" );
        try {
            employeeService.saveEmployee( employee );
        } catch ( EmployeeAlreadyExistException | InvalidUserInputException e ) {
            fail( "Failed to save employee" );
        }
        Employee employee1 = new Employee();
        employee1.setFirstName( "TEST" );
        employee1.setLastName( "TEST" );
        employee1.setDepartment( "TEST" );
        try {
            employeeService.saveEmployee( employee1 );
            fail( "Exception should be raised as employee already exist" );
        } catch ( EmployeeAlreadyExistException | InvalidUserInputException e ) {
            
        }
        employeeService.deleteEmployee( employee );
    }

    @Test
    public void testSaveEmployeeNullOrEmptyFirstName() {
        Employee employee = new Employee();
        employee.setFirstName( null );
        employee.setLastName( "TEST" );
        employee.setDepartment( "TEST" );
        try {
            employeeService.saveEmployee( employee );
        } catch ( EmployeeAlreadyExistException | InvalidUserInputException e ) {
            Assert.assertTrue( e instanceof InvalidUserInputException );
        }
    }

    @Test
    public void testSaveEmployeeNullorEmptyLastName() {
        Employee employee = new Employee();
        employee.setFirstName( "TEST" );
        employee.setLastName( null );
        employee.setDepartment( "TEST" );
        try {
            employeeService.saveEmployee( employee );
        } catch ( EmployeeAlreadyExistException | InvalidUserInputException e ) {
            Assert.assertTrue( e instanceof InvalidUserInputException );
        }
    }

    @Test
    public void testSaveEmployeeNullorEmptyDepartment() {
        Employee employee = new Employee();
        employee.setFirstName( "TEST" );
        employee.setLastName( "TEST" );
        employee.setDepartment( null );
        try {
            employeeService.saveEmployee( employee );
        } catch ( EmployeeAlreadyExistException | InvalidUserInputException e ) {
            Assert.assertTrue( e instanceof InvalidUserInputException );
        }
    }
    
    @Test
    public void testGetEmployees() {
        Employee employee = new Employee();
        employee.setFirstName( "TEST" );
        employee.setLastName( "TEST" );
        employee.setDepartment( "TEST" );
        try {
            employeeService.saveEmployee( employee );
        } catch ( EmployeeAlreadyExistException | InvalidUserInputException e ) {
            fail( "Failed to save employee" );
        }
        Assert.assertNotNull( employeeService.getEmployees() );
        Assert.assertEquals( 1, employeeService.getEmployees().size() );
        employeeService.deleteEmployee( employee );
    }
    

}
