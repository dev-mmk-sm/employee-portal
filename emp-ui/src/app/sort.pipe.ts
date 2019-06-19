import { Pipe, PipeTransform } from "@angular/core";
import { Employee } from './employees/employee';

@Pipe({
    name: "sort"
})
export class SortPipe implements PipeTransform {
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