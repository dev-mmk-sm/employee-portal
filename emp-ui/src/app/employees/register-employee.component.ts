import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl, ValidatorFn } from '@angular/forms';
import { NgbInputDatepicker } from '@ng-bootstrap/ng-bootstrap';

import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { Router } from '@angular/router';

@Component({
    templateUrl: './register-employee.component.html',
    styleUrls: ['./register-employee.component.css']
})
export class RegisterEmployeeComponent implements OnInit {
    employeeForm: FormGroup;
    employee: Employee;
    errorMessage: string;

    constructor(private fb: FormBuilder, private employeeService: EmployeeService, private router: Router) { }

    ngOnInit() {
        this.employeeForm = this.fb.group({
            firstName: ['', [Validators.required, Validators.minLength(3)]],
            lastName: ['', [Validators.required, Validators.maxLength(50)]],
            gender: 'Male',
            dob: [''],
            department: ''
        });

        this.employeeForm.get('gender').valueChanges.subscribe(
            value => this.setGender(value)
        );


        this.employeeForm.get('dob').valueChanges.subscribe(
            value => this.setDob(value)
        );
    }

    save() {
        if (this.employeeForm.valid) {
            //TODO: Route here to Employee list after doing the Save call
            console.log(this.employeeForm);
            console.log('Saved: ' + JSON.stringify(this.employeeForm.value));

            this.employeeService.getEmployees().subscribe(
                empoyee => {
                    this.router.navigate(['/', 'employees']);
                },
                error => this.errorMessage = <any>error
            );
        } else {
            console.log("Validations failed! Cannot proceed further");
            this.errorMessage = "Validations failed! Cannot proceed further";
        }
    }

    setDob(dob: string): void {
        console.log(dob);
    }

    setGender(gender: string): void {
        if (gender === 'Male') {

        } else {

        }
    }

}
