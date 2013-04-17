Feature: Find Order ID by an External Reference
  As a fix tool developer
  I want record the uniquely generated order ID of a new order against an external reference for that order
  So that I can easily retrieve that order's ID later if I need to cancel it

  Scenario: Recall the order ID of an order by an external reference
    Given a new order has been recorded with an order ID of '12345' and an external reference of 'someOrder'
    When I request the order ID for this order by it's external reference
    Then the order ID is returned