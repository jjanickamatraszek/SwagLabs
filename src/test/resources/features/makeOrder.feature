Feature: Make order

  User should be able to order chosen products.

  Scenario Outline: User should be able to order products successfully.
    Given <User> is logged in
    And added products to cart
    When proceeds to checkout
    Then makes successful order

    Examples:
    |User|
    |KATE|
    |JOHN|
