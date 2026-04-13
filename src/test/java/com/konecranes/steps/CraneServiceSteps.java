package com.konecranes.steps;

import com.konecranes.service.CraneService;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class CraneServiceSteps {

    private CraneService service;
    private int capacity;
    private boolean result;
    private Exception exception;

    @Given("the crane has a capacity of {int} kg")
    public void a_crane_with_capacity(int capacity) {
        this.capacity = capacity;
        service = new CraneService();
    }

    @When("the operator attempts to lift a load of {int} kg")
    public void i_try_to_lift(int load) {
        try {
            result = service.canLift(capacity, load);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("the lift operation should be successful")
    public void operation_should_be_successful() {
        assertTrue(result);
    }
}