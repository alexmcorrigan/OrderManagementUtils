package com.mcorrigal.omu.shadowBook.features;

import com.mcorrigal.omu.order.Order;
import com.mcorrigal.omu.shadowBook.NoOrderFoundException;
import com.mcorrigal.omu.shadowBook.ShadowBook;
import com.mcorrigal.omu.shadowBook.SimpleShadowBook;

import static com.mcorrigal.omu.TestConstants.EXTERNAL_ORDER_REFERENCE;
import static com.mcorrigal.omu.TestConstants.ORDER_ID;

public class ShadowBookStepDefinitions {

    private ShadowBook shadowBook;

    public ShadowBookStepDefinitions() {
        shadowBook = new SimpleShadowBook();
    }

    public String addAnOrderToTheShadowBook() {
        return addAnOrderToTheShadowBook(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
    }

    public String addAnOrderToTheShadowBook(String externalReference, String orderID) {
        shadowBook.add(Order.createNew(externalReference, orderID));
        return ORDER_ID;
    }

    public ShadowBook getShadowBook() {
        return shadowBook;
    }

    public void cancelOrder(String orderId) throws NoOrderFoundException {
        shadowBook.cancel(orderId);
    }

    public void fillOrder(String orderId) throws NoOrderFoundException {
        shadowBook.fill(orderId);
    }

    public void partiallyFillOrder(String orderId) {
        shadowBook.partiallyFill(orderId);
    }
}
