/*
 * The error class
 */
package com.sg.employee.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 *  @author Manju Kumar Mohan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-19T05:35:08.152Z")

public class Error {
	@JsonProperty("code")
	private Integer code = null;

	@JsonProperty("message")
	private String message = null;

	public Error code(Integer code) {
		this.code = code;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Error message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Error error = (Error) o;
		return Objects.equals(this.code, error.code) && Objects.equals(this.message, error.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Error {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
