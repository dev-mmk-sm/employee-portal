import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
    templateUrl: './employee-list-component.html',
    styleUrls: ['./employee-list-component.css']
})
export class EmployeeListComponent implements OnInit {

    pageTitle = 'Employee List';
    errorMessage = '';
    employees: Employee[] = [];

    constructor(private employeeService: EmployeeService,
        private route: ActivatedRoute) { }


    ngOnInit(): void {
        this.employeeService.getEmployees().subscribe(
            employees => {
                this.employees = employees;
            },
            error => this.errorMessage = <any>error
        );
    }
}
