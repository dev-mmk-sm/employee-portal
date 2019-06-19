import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListComponent } from './employee-list.component';
import * as MockEmployeeData from './testData/EmpMockData'
import { EmployeeService } from './employee.service';
import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from './employee';
import { SortPipe } from '../sort.pipe';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';

import { of } from 'rxjs';

var dummyData = MockEmployeeData.dummyData;

class MockEmployeeService {
    getEmployees() {
        return of({ json: () => dummyData });
    }
}

@Pipe({ name: 'sort' })
class MockPipe implements PipeTransform {
    transform(array: Array<Employee>, field: string): any[] {
        if (!Array.isArray(array)) {
            return;
        }
        array.sort((a: Employee, b: Employee) => {
            if (a.firstName < b.firstName) {
                return -1;
            } else if (a.firstName > b.firstName) {
                return 1;
            } else {
                return 0;
            }
        });
        return array;
    }
}


describe('EmployeeListComponent', () => {
    let component: EmployeeListComponent;
    let fixture: ComponentFixture<EmployeeListComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [EmployeeListComponent, MockPipe],
            imports: [RouterTestingModule, HttpClientModule],
            providers: [{ provide: EmployeeService, useClass: MockEmployeeService },
            { provide: SortPipe, useClass: MockPipe }]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(EmployeeListComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });

    it('should successfully call ngOninit', () => {
        component.ngOnInit();
        expect(component).toBeTruthy();
    });
});
