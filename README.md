## Konecranes Test Automation Framework

This project is a test automation framework developed to validate both UI and backend functionalities of the Konecranes application. 
It is built with modern technologies and follows a scalable, maintainable, and behavior-driven approach.

## Project Overview

The framework enables:

End-to-end UI testing
API/backend validation
BDD-style scenario definitions (Given / When / Then)
CI integration with GitHub Actions
Scalable and maintainable test structure
Parallel test execution with configurable threads
Allure reporting with screenshot attachments on failure
Automated CI/CD pipeline orchestration

## Tech Stack

This framework is built using modern and scalable testing technologies:

Java 17
JUnit 5
Cucumber
Gherkin (BDD)
Playwright
Gradle

## Testing Approach

The project follows Behavior-Driven Development (BDD):

Scenarios are written in Gherkin syntax
Tests are executed using Cucumber with JUnit 5
UI automation is handled by Playwright
Backend validations are integrated into the same framework

## Setup

Clone the repository:

git clone https://github.com/sselda/konecranes-automation.git
cd konecranes-automation

Build the project:

./gradlew build

Run tests:

./gradlew test

## Running Tests with Tags
./gradlew test -Dcucumber.filter.tags="@smoke"

Example tags:

@smoke
@regression
@ui
@api

## Parallel Execution

The framework supports parallel test execution to reduce overall test run time and improve feedback speed.

Tests can be executed in parallel using configurable thread counts
Supports parallel execution at scenario or feature level
Improves efficiency in CI/CD pipelines
Fully compatible with Cucumber and JUnit 5

* Example configuration (JUnit 5):

junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=concurrent

* Example configuration (Cucumber):

cucumber.execution.parallel.enabled=true
cucumber.execution.parallel.config.strategy=fixed
cucumber.execution.parallel.config.fixed.parallelism=4

## Test Management Integration

The framework is integrated with Xray for centralized test management and traceability.

* Cucumber test results are automatically exported in JSON format
* GitHub Actions pipeline uploads test results to Xray
* Test Executions are created and updated automatically
* Scenario steps are synchronized with Xray test cases
* Enables full visibility of test results within Jira

This integration ensures that test execution results are consistently tracked and linked to requirements.

## CI/CD Integration

The project uses GitHub Actions for continuous integration and automated test execution.

* Tests are triggered on every push and pull request
* Cucumber results are generated and stored during execution
* Results are automatically sent to Xray after test completion
* Supports scalable and maintainable pipeline configuration

This setup enables continuous feedback and seamless integration between automation and test management tools.


## Reporting

The framework supports Allure reporting:

Detailed step-level insights
Failure analysis with logs
Automatic screenshot capture on test failures
Easy integration into CI pipelines

Screenshots are attached to the report to help identify UI issues quickly.
