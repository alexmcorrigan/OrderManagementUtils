package com.mcorrigal.omu.shadowBook;

import com.mcorrigal.omu.order.Order;

import java.util.List;

public interface ShadowBook {

    void add(Order order);

    List<Order> getAllOrders();

    String orderIdFor(String externalReference) throws Exception;

    void cancel(String orderId) throws NoOrderFoundException;

    boolean orderIsActive(String orderId) throws NoOrderFoundException;

    void fill(String orderId) throws NoOrderFoundException;

    void partiallyFill(String orderId);
}
