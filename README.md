# Selenium Automation Framework 🧪

This repository contains automated UI tests implemented using **Selenium WebDriver**, **Java**, and **Maven**.

---

## 🚀 Running Tests

All useful commands:

```bash
# Clean and run all tests
mvn clean test

# Run a single test class example
mvn test -Dtest=LoginTest

# Run a specific test method inside a class example
mvn test -Dtest=LoginTest#validLogin

# Run tests by groups (if TestNG groups are used)
mvn test -Dgroups=smoke

# Run tests with Maven profile (example: regression suite)
mvn clean test -P regression

# Run tests with browser parameter (default: chrome)
mvn test -Dbrowser=firefox

# Run tests in parallel (using TestNG DataProvider thread count)
mvn test -Ddataproviderthreadcount=4


#Notes

Uses Page Object Model (POM) for better maintainability.

Supports running on multiple browsers (Chrome, Firefox, Edge).

Can be integrated with CI/CD tools (Jenkins, GitHub Actions).

TestNG groups (@smoke, @regression) help organize test execution.


#Reports

TestNG Report: Generated automatically in test-output/index.html.

Extent Report (if integrated): Open from target/extent-reports/.