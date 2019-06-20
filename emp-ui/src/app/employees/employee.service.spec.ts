import { TestBed, async, inject, getTestBed } from '@angular/core/testing';
import { EmployeeService } from './employee.service';
import * as constants from '../app.constants';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as MockEmployeeData from './testData/EmpMockData';
import { of } from 'rxjs';
import { Employee } from './employee';

const dummyData = MockEmployeeData.dummyData;

class MockEmployeeService {
    getEmployees() {
        return of({ json: () => dummyData });
    }
}


describe("EmployeeService", () => {
    let injector: TestBed;
    let service: EmployeeService;
    let httpMock: HttpTestingController;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [EmployeeService]
        });
        injector = getTestBed();
        service = injector.get(EmployeeService);
        httpMock = injector.get(HttpTestingController);
    });

    afterEach(() => {
        httpMock.verify();
    });

    describe("getEmployees()", () => {
        it('should return an Observable<Employee>', () => {
            service.getEmployees().subscribe((data) => {
                expect(data.length).toBe(5);
                expect(data[0].firstName).toEqual('Manju');
                expect(data[1].firstName).toEqual('Ramya');
                expect(data[2].firstName).toEqual('Naveen');
                expect(data[3].firstName).toEqual('Kamlesh');
            });

            const req = httpMock.expectOne('assets/employees.json');
            expect(req.request.method).toBe("GET");
            req.flush(dummyData);
        });
    });

    describe('registerEmployee()', () => {
        it('Should pass.',
            inject([EmployeeService, HttpTestingController], (employeeService, backend) => {
                let employee = new Employee();
                employee.firstName = "Krishna";
                employee.lastName = "Kumar";
                employee.gender = "Male";
                employee.dob = "15-02-1989"
                employee.department = "CSE";

                service.registerEmployee(employee).subscribe((next) => {
                    expect(next).toBeNull();
                });
                backend.expectOne(constants.EMPLOYEE_POST_URL).flush(null, { status: 200, statusText: 'Ok' });
            }));
    });
});