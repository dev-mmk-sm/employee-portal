export class Employee {
    id: number;
    firstName: string;
    lastName: string;
    gender: string;
    dob: string;
    department: string;
}


export class EmployeeResolved {
    employee: Employee;
    error?: any;
}