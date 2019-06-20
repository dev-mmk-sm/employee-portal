/*
 * A wrapper class containing List of employees
 */
package com.sg.employee.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

/**
 * @author Manju Kumar Mohan
 */
@Validated
@javax.annotation.Generated ( value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-19T05:35:08.152Z" )

public class Employees extends ArrayList<Employee> {

    public Employees( Collection<Employee> c ) {
        super( c );
    }

    /**
     * 
     */
    private static final long serialVersionUID = 6279739900148190717L;

    @Override
    public boolean equals( java.lang.Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode() );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "class Employees {\n" );
        sb.append( "    " ).append( toIndentedString( super.toString() ) ).append( "\n" );
        sb.append( "}" );
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString( java.lang.Object o ) {
        if ( o == null ) {
            return "null";
        }
        return o.toString().replace( "\n", "\n    " );
    }
}
