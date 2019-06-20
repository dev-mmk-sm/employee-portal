/*
 * InvalidUserInputException.java
 * 
 * Copyright (c) 2019 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package com.sg.employee.exception;

/**
 * @author 212580430
 *
 */
public class InvalidUserInputException extends Exception {

    private static final long serialVersionUID = 4799819970240752356L;

    public InvalidUserInputException() {
        super();
    }

    public InvalidUserInputException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }

    public InvalidUserInputException( String message, Throwable cause ) {
        super( message, cause );
    }

    public InvalidUserInputException( String message ) {
        super( message );
    }

    public InvalidUserInputException( Throwable cause ) {
        super( cause );
    }
    
    

}
