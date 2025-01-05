# Online Shopping Mobile Automation
This project will be used to implement functional automation test cases using Cucumber, Appium and TestNG.

## Prerequisites
- Maven
- Java 

## Project Installation:
 1. Clone the git project
 2. Open the project in the preferred IDE (We are using IntelliJ)
 3. Import the maven dependencies 

## Running Test Scenarios:

 To run the scenarios, use the below command in your terminal
```
mvn clean test
```
 To run the scenario with a specific tag, use the below command
```
mvn test -Dcucumber.filter.tags="@Scenario1"
```
## Test Report:
After running the test scenarios, the full report cucumeber.html can be found under the `target/cucumber-report/` path.

## Note:
 1. Configure your own android emulator and fill the details in the android.json
 
