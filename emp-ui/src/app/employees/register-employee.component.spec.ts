import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterEmployeeComponent } from './register-employee.component';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormBuilder } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

describe('RegisterEmployeeComponent', () => {
    let component: RegisterEmployeeComponent;
    let fixture: ComponentFixture<RegisterEmployeeComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [RegisterEmployeeComponent],
            imports: [RouterTestingModule, HttpClientModule, ReactiveFormsModule, NgbModule],
            providers: [FormBuilder]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(RegisterEmployeeComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });

    it('should test Save with no values', () => {
        component.save();
        expect(component.employeeForm.valid).toBe(false);
    });

    it('should test Save with appropriate values', () => {
        updateForm("Manju", "Kumar");
        component.save();
        expect(component.employeeForm.valid).toBe(true);
    });

    function updateForm(firstName, lastName) {
        component.employeeForm.controls['firstName'].setValue(firstName);
        component.employeeForm.controls['lastName'].setValue(lastName);
    }
});

