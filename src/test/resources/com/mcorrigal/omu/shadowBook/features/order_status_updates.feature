Feature: Order Status Updates
  As a fix tool developer
  I want record to record the status updates of order's I have submitted
  So that I can determine if I can cancel an order or not

  Scenario: An order has been cancelled
    Given a new order has been cancelled
    When I request if the order is active
    Then I am told it is not

  Scenario: An order has been filled
    Given a new order has been filled
    When I request if the order is active
    Then I am told it is not

  Scenario: An order has been partially filled
    Given a new order has been partially filled
    When I request if the order is active
    Then I am told it is

  Scenario: An order is still new
    Given a new order
    When I request if the order is active
    Then I am told it is