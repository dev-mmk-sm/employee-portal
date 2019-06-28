import { SortPipe } from "./sort.pipe";
import * as MockEmployeeData from './employees/testData/EmpMockData';
import { Employee } from './employees/employee';

describe("SortPipe", () => {
    let dummyData;

    beforeEach(() => {
        dummyData = MockEmployeeData;
    });

    it("Should sort the array and the length of the array should be 5", () => {
        //Arrage
        let pipe = new SortPipe();

        //Act
        let returnVal: Array<Employee> = pipe.transform(dummyData,"firstName");

        //Assert
        expect(returnVal.length).toEqual(5);
    });    

    it("Should sort the array and the first element should be Kamlesh", () => {
        //Arrage
        let pipe = new SortPipe();

        //Act
        let returnVal: Array<Employee> = pipe.transform(dummyData,"firstName");

        //Assert
        expect(returnVal[0].firstName).toEqual("Kamlesh");
    });

    it("Should sort the array and the last element should be Ramya", () => {
        //Arrage
        let pipe = new SortPipe();

        //Act
        let returnVal: Array<Employee> = pipe.transform(dummyData,"firstName");

        //Assert
        expect(returnVal[returnVal.length].firstName).toEqual("Ramya");
    });
});