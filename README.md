# employee-portal
A sample application showcasing Angular and Spring Boot
employee-ui contains UI project. To run the same, clone the repository and do the following:
	1. npm install
	2. ng serve

Sample list of employees is present in the assets folder which will be loaded in devmode without the backend server.

To run all the test cases and see the code coverage, please run ng test --code-coverage

employee-service, is a spring boot application. Follow the below steps to setup
	1. After cloning, import the gradle project onto STS/eclipse
	2. Do a gradle refresh on the project so that the dependencies are downloaded
	3. Testcases are present in the test package
	4. Do a gradle build to generate the jar and deploy the same. 
	5. Default port to run the server is configured to be 8090. It can be changed from application.properties, server.port
