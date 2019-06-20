/**
 * The Employee service implementation class responsible for handling the business logic
 */
package com.sg.employee.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.employee.api.EmployeeApiController;
import com.sg.employee.dao.IEmployeeDAO;
import com.sg.employee.exception.DAOException;
import com.sg.employee.exception.EmployeeAlreadyExistException;
import com.sg.employee.exception.InvalidUserInputException;
import com.sg.employee.model.Employee;
import com.sg.employee.model.Employees;

/**
 * @author Manju Kumar Mohan
 */
@Service
public class EmployeeService implements IEmployeeService {

    private static final Logger log = LoggerFactory.getLogger( EmployeeApiController.class );

    @Autowired
    private IEmployeeDAO employeeDAO;

    @Override
    public void saveEmployee( Employee employee ) throws EmployeeAlreadyExistException, InvalidUserInputException {
        try {
            validate( employee );
            employeeDAO.saveEmployee( employee );
        } catch ( DAOException e ) {
            log.error( "Failed to save employee", e );
            throw new EmployeeAlreadyExistException( e.getMessage() );
        }

    }

    @Override
    public Employees getEmployees() {
        return employeeDAO.getEmployees();
    }
    
    @Override
    public boolean deleteEmployee( Employee employee ) {
        return employeeDAO.deleteEmployee( employee );
    }
    
    
    private void validate( Employee employee ) throws InvalidUserInputException {

        if ( isNullOrEmpty( employee.getDepartment() ) || isNullOrEmpty( employee.getFirstName() ) || isNullOrEmpty( employee.getLastName() ) ) {
            throw new InvalidUserInputException();
        }

    }

    private boolean isNullOrEmpty( String input ) {
        if ( Objects.isNull( input ) || input.isEmpty() ) {
            return true;
        }
        return false;
    }

}
