import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EmployeeListComponent } from './employee-list.component';


import { SharedModule } from '../shared.module';
import { EmployeeService } from './employee.service';
import { SortPipe } from '../sort.pipe';

@NgModule({
    imports: [
        SharedModule,
        RouterModule.forChild([
            {
                path: '',
                component: EmployeeListComponent
            }
        ])
    ],
    declarations: [
        EmployeeListComponent,
        SortPipe
    ],
    providers: [EmployeeService]
})
export class EmployeeModule { }
