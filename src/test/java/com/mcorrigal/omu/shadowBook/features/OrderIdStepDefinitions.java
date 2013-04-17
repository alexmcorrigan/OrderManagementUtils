package com.mcorrigal.omu.shadowBook.features;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class OrderIdStepDefinitions {

    private ShadowBookStepDefinitions shadowBookStepDefinitions;
    private String orderId;
    private String externalReference;
    private String foundOrderId;

    @Before
    public void setUp() {
        shadowBookStepDefinitions = new ShadowBookStepDefinitions();
    }

    @Given("^a new order has been recorded with an order ID of '(\\d+)' and an external reference of '(.*)'$")
    public void aNewBuyOrder(String orderId, String externalReference) throws Throwable {
        this.orderId = orderId;
        this.externalReference = externalReference;
        shadowBookStepDefinitions.addAnOrderToTheShadowBook(externalReference, orderId);
    }

    @When("^I request the order ID for this order by it's external reference$")
    public void requestOrderIdForExternalReference() throws Throwable {
        foundOrderId = shadowBookStepDefinitions.getShadowBook().orderIdFor(externalReference);
    }

    @Then("^the order ID is returned$")
    public void theOrderIdIsReturned() throws Throwable {
        assertEquals(orderId, foundOrderId);
    }

}
