Feature: Employee-service

Narrative: Employee-service shall provide details of all the employees. It shall also provide functionality to save an employee when provided with the necessary values.
Depending on the request, the service shall respond with either
1) All fields with a status of 200 or
2) Empty response with a status code of 204 in case of zero results for the search or
3) Error code 400 when invalid or unsupported parameters are used.

@test_1
  Scenario Outline: send a valid request to fetch all the employees.
    Given Employee service is up and running
    When the consumer sends a request for displaying all the employees
    Then Employee service should return response of employees

@test_2
  Scenario Outline: send a valid request to save the employee details.
    Given Employee service is up and running
    When the consumer sends a save employee request with <json>
    Then Employee service should save the employee
	And the list of employees is seen on the UI
    Examples:
	 | json |
	 | {"firstName":"Manju","lastName":"kumar", "gender":"Male", "dob":"15-02-1989", "department":"CSE"}|
	 
@test_3
  Scenario Outline: send an invalid request to save the employee details.
    Given Employee service is up and running
    When the consumer sends a save employee request with <json>
    Then Employee service should throw ValidationFailedException
    Examples:
	 | json |
	 | {"firstName":"","lastName":"", "gender":"Male", "dob":"15-02-1989", "department":"CSE"}|
	 
@test_4
  Scenario Outline: send a valid request to save the employee details which is already saved and the service should not process the request
    Given Employee service is up and running
    When the consumer sends a save employee request with <json> which is already present
    Then Employee service should throw EmployeeAlreadyPresentException
    Examples:
	 | json |
	 | {"firstName":"Manju","lastName":"Kumar", "gender":"Male", "dob":"15-02-1989", "department":"CSE"}|