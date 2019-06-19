import { Injectable, isDevMode } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Employee } from './employee';
import * as constants from '../app.constants';

@Injectable({
    providedIn: 'root'
})
export class EmployeeService {
    constructor(private http: HttpClient) { }

    getEmployees(): Observable<Employee[]> {

        if (isDevMode()) {
            return this.http.get<Employee[]>(constants.EMPLOYEE_DUMMY_DATA_LOCAL)
                .pipe(
                    tap(data => console.log(JSON.stringify(data))),
                    catchError(this.handleError)
                );
        } else {
            return this.http.get<Employee[]>(constants.EMPLOYEE_GET_ALL_URL)
                .pipe(
                    tap(data => console.log(JSON.stringify(data))),
                    catchError(this.handleError)
                );
        }
    }

    registerEmployee(employee: Employee): Observable<Employee> {
        const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        employee.id = null;
        return this.http.post<Employee>(constants.EMPLOYEE_POST_URL, employee, { headers: headers })
            .pipe(
                tap(data => console.log('Register employee: ' + JSON.stringify(data))),
                catchError(this.handleError)
            );
    }

    private handleError(err) {
        // in a real world app, we may send the server to some remote logging infrastructure
        // instead of just logging it to the console
        let errorMessage: string;
        if (err.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            errorMessage = `An error occurred: ${err.error.message}`;
        } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            errorMessage = `Backend returned code ${err.status}: ${err.body.error}`;
        }
        console.error(err);
        return throwError(errorMessage);
    }
}
