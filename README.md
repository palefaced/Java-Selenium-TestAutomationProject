Project Structure Overview

Automation Framework

Tools:

Selenium: For UI automation.
TestNG: For test management.
Design Pattern: Custom Page Object Model (POM).

Test Data Management

Source: JSON files are used as the data source for test cases.
Purpose: Enables dynamic test execution by fetching inputs from structured JSON data.
Build and Dependency Management

Maven: Used for managing dependencies, project builds, and running test suites.
Version Control and CI/CD Integration

GitHub Actions: Configured to trigger automated test runs on code pushes.
Jenkins: Integrated for additional CI/CD pipeline management and test execution.
Test Reporting

HTML Reports: Implemented to generate detailed reports for each test run, including passed, failed, and skipped test cases.
Test Cases

Logging and debugging: Implemented logging using Log4J2 to enhance debugging and test execution visibility. Added descriptive logging for ElementActionHelperClass, while other classes log the full stack trace only upon test failure. Detailed logs can be found in logs/test.log.

TestNG Retry mechanism Integration: "Integrated TestNG Retry mechanism to enhance test stability. Failed tests are retried twice before being marked as failed."

Plans for the future: 
~100 test cases covering a 2-3-page web application.
Focused on functional testing and ensuring comprehensive coverage of key scenarios.
Future Enhancements
Notifications: Email alerts for failed tests or detected bugs + screenshots, Allure report!

Key Accomplishments:
Successfully integrated GitHub Actions and Jenkins for CI/CD.
Switched to using JSON files for test data management.
Integrated TestNG Retry mechanism.
Implemented Log4J2 logging.
Implemented HTML reporting for better visibility and professional-grade test result representation.
