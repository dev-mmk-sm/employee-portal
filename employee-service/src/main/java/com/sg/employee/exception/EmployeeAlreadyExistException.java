/**
 * Employee Already exists Exception class
 */
package com.sg.employee.exception;

/**
 * @author Manju Kumar Mohan
 *
 */
public class EmployeeAlreadyExistException extends Exception {

	private static final long serialVersionUID = -1338544830612966284L;

	/**
	 * 
	 */
	public EmployeeAlreadyExistException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public EmployeeAlreadyExistException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public EmployeeAlreadyExistException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public EmployeeAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public EmployeeAlreadyExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
