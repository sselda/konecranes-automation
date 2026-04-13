Feature: Crane load validation

  @E2E-4 @TESTID-3 @regression
  Scenario: Lifting load within crane capacity
    Given the crane has a capacity of 1000 kg
    When the operator attempts to lift a load of 500 kg
    Then the lift operation should be successful