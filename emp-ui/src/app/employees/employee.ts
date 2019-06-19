export interface Employee {
    id: number;
    firstName: string;
    lastName: string;
    gender: string;
    dob: string;
    department: string;
}


export interface EmployeeResolved {
    employee: Employee;
    error?: any;
}