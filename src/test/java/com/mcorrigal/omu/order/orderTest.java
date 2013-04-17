package com.mcorrigal.omu.order;

import org.junit.Test;

import static com.mcorrigal.omu.TestConstants.EXTERNAL_ORDER_REFERENCE;
import static com.mcorrigal.omu.TestConstants.ORDER_ID;
import static org.junit.Assert.*;

public class orderTest {

    @Test
    public void testNewOrderIsActive() throws Exception {
        Order order = Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
        assertTrue(order.isActive());
    }

    @Test
    public void testGetOrderID() throws Exception {
        Order order = Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
        assertEquals(ORDER_ID, order.getOrderID());
    }

    @Test
    public void testOrderHasExternalReference() throws Exception {
        Order order = Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
        assertTrue(order.hasExternalReference(EXTERNAL_ORDER_REFERENCE));
        assertFalse(order.hasExternalReference("invalid"));
    }

    @Test
    public void testMakeOrderInactive() throws Exception {
        Order order = Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
        order.makeInactive();
        assertFalse(order.isActive());
    }
}
