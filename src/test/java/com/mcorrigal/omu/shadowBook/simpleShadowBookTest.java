package com.mcorrigal.omu.shadowBook;

import com.mcorrigal.omu.order.Order;
import org.junit.Before;
import org.junit.Test;

import static com.mcorrigal.omu.TestConstants.EXTERNAL_ORDER_REFERENCE;
import static com.mcorrigal.omu.TestConstants.ORDER_ID;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;

public class simpleShadowBookTest {

    private ShadowBook shadowBook;

    @Before
    public void setUp() throws Exception {
        shadowBook = new SimpleShadowBook();
    }

    @Test
    public void testAddNewOrder() throws Exception {
        Order order = Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
        shadowBook.add(order);
        assertEquals(order, shadowBook.getAllOrders().get(0));
    }

    @Test
    public void testGetOrderIdForExternalReference() throws Exception {
        shadowBook.add(Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID));
        assertEquals(ORDER_ID, shadowBook.orderIdFor(EXTERNAL_ORDER_REFERENCE));
    }

    @Test
    public void testExceptionWhenNoOrderFoundForAnExternalReference() throws Exception {
        Exception exception = null;
        try {
            shadowBook.orderIdFor(EXTERNAL_ORDER_REFERENCE);
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof NoOrderFoundException);
        assertEquals("No order found for external reference " + EXTERNAL_ORDER_REFERENCE, exception.getMessage());
    }

    @Test
    public void testCancelOrder() throws NoOrderFoundException {
        Order order = Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
        shadowBook.add(order);
        shadowBook.cancel(ORDER_ID);
        assertFalse(order.isActive());
    }

    @Test
    public void testOrderToCancelCantBeFound() throws Exception {
        NoOrderFoundException noOrderFoundException = null;
        try {
            shadowBook.cancel(ORDER_ID);
        } catch (NoOrderFoundException caughtException) {
            noOrderFoundException = caughtException;
        }
        assertNotNull(noOrderFoundException);
        assertEquals("No order found for Order ID " + ORDER_ID, noOrderFoundException.getMessage());
    }

    @Test
    public void testFillOrder() throws Exception {
        Order order = Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
        shadowBook.add(order);
        shadowBook.fill(ORDER_ID);
        assertFalse(order.isActive());
    }

    @Test
    public void testPartiallyFillOrder() throws Exception {
        Order order = Order.createNew(EXTERNAL_ORDER_REFERENCE, ORDER_ID);
        shadowBook.add(order);
        shadowBook.partiallyFill(ORDER_ID);
        assertTrue(order.isActive());
    }

}
