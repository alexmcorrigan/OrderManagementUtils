package com.mcorrigal.omu.shadowBook;

import com.mcorrigal.omu.order.Order;

import java.util.ArrayList;
import java.util.List;

public class SimpleShadowBook implements ShadowBook {

    private List<Order> orders = new ArrayList<Order>();

    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public String orderIdFor(String externalReference) throws NoOrderFoundException {
        String orderId = null;
        for (Order order : orders) {
            if (order.hasExternalReference(externalReference)) {
                orderId = order.getOrderID();
            }
        }
        if (orderId == null) {
            throw new NoOrderFoundException("No order found for external reference " + externalReference);
        } else {
            return orderId;
        }
    }

    @Override
    public void cancel(String orderId) throws NoOrderFoundException {
        Order orderToCancel = orderForId(orderId);
        orderToCancel.makeInactive();
    }

    @Override
    public void fill(String orderId) throws NoOrderFoundException {
        Order orderToFill = orderForId(orderId);
        orderToFill.makeInactive();
    }

    @Override
    public void partiallyFill(String orderId) {
    }

    @Override
    public boolean orderIsActive(String orderId) throws NoOrderFoundException {
        return orderForId(orderId).isActive();
    }

    private Order orderForId(String orderId) throws NoOrderFoundException {
        Order foundOrder = null;
        for (Order order : orders) {
            if (order.getOrderID().equals(orderId)) {
                foundOrder = order;
            }
        }
        if (foundOrder == null) {
            throw new NoOrderFoundException("No order found for Order ID " + orderId);
        } else {
            return foundOrder;
        }
    }

}
