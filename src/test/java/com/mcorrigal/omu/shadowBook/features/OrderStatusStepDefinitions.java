package com.mcorrigal.omu.shadowBook.features;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderStatusStepDefinitions {

    private ShadowBookStepDefinitions shadowBookStepDefinitions;
    private String orderId;
    private boolean orderIsActive;

    @Before
    public void setUp() {
        shadowBookStepDefinitions = new ShadowBookStepDefinitions();
    }

    @Given("^a new order has been cancelled$")
    public void aNewOrderHasBeenCancelled() throws Throwable {
        orderId = shadowBookStepDefinitions.addAnOrderToTheShadowBook();
        shadowBookStepDefinitions.cancelOrder(orderId);
    }

    @Given("^a new order has been filled$")
    public void a_new_order_has_been_filled() throws Throwable {
        orderId = shadowBookStepDefinitions.addAnOrderToTheShadowBook();
        shadowBookStepDefinitions.fillOrder(orderId);
    }

    @Given("^a new order has been partially filled$")
    public void a_new_order_has_been_partially_filled() throws Throwable {
        orderId = shadowBookStepDefinitions.addAnOrderToTheShadowBook();
        shadowBookStepDefinitions.partiallyFillOrder(orderId);
    }

    @Given("^a new order$")
    public void a_new_order() throws Throwable {
        orderId = shadowBookStepDefinitions.addAnOrderToTheShadowBook();
    }

    @When("^I request if the order is active$")
    public void I_request_if_the_order_is_active() throws Throwable {
        orderIsActive = shadowBookStepDefinitions.getShadowBook().orderIsActive(orderId);
    }

    @Then("^I am told it is not$")
    public void I_am_told_it_is_not() throws Throwable {
        assertFalse(orderIsActive);
    }


    @Then("^I am told it is$")
    public void I_am_told_it_is() throws Throwable {
        assertTrue(orderIsActive);
    }

}
