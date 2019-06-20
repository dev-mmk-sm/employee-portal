/*
 * This is a POJO class to hold the Employee details.
 */

package com.sg.employee.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Manju Kumar Mohan
 */

public class Employee {
	private Long id = null;

	private String firstName = null;

	private String lastName = null;

	private String gender = null;

	private String dob = null;

	private String department = null;

	public Employee id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Employee lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee gender(String gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Get gender
	 * 
	 * @return gender
	 **/
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Employee dob(String dob) {
		this.dob = dob;
		return this;
	}

	/**
	 * Get dob
	 * 
	 * @return dob
	 **/
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Employee department(String department) {
		this.department = department;
		return this;
	}

	/**
	 * Get department
	 * 
	 * @return department
	 **/
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Employee employee = (Employee) o;
		return Objects.equals(this.firstName, employee.firstName)
				&& Objects.equals(this.lastName, employee.lastName)  && Objects.equals(this.department, employee.department);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, gender, dob, department);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Employee {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
		sb.append("    department: ").append(toIndentedString(department)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
