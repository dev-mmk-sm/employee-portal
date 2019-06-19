import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl, ValidatorFn } from '@angular/forms';
import { NgbInputDatepicker } from '@ng-bootstrap/ng-bootstrap';

import { Employee } from './employee';

@Component({
    templateUrl: './register-employee.component.html',
    styleUrls: ['./register-employee.component.css']
})
export class RegisterEmployeeComponent implements OnInit {
    employeeForm: FormGroup;
    employee: Employee;
    emailMessage: string;

    constructor(private fb: FormBuilder) { }

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
    }

    save() {
        console.log(this.employeeForm);
        console.log('Saved: ' + JSON.stringify(this.employeeForm.value));

        //TODO: Route here to Employee list after doing the Save call
    }

    setGender(gender: string): void {
        if (gender === 'Male') {

        } else {

        }
    }

}
