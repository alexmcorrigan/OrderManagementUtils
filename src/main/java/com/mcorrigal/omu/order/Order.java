package com.mcorrigal.omu.order;

public class Order {

    protected String externalReference;
    protected String orderID;
    private boolean active;

    public static Order createNew(String externalReference, String orderID) {
        return new Order(externalReference, orderID);
    }

    private Order(String externalReference, String orderID) {
        this.externalReference = externalReference;
        this.orderID = orderID;
        active = true;
    }

    public String getOrderID() {
        return orderID;
    }

    public boolean hasExternalReference(String externalReference) {
        return this.externalReference.equals(externalReference);
    }

    public boolean isActive() {
        return active;
    }

    public void makeInactive() {
        active = false;
    }
}
