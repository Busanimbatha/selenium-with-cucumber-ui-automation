@AddProduct
Feature: Buy Order Functionality

  As a www.takealot.co.za user, I want the ability to add a product to the cart and view my product in the cart

  @Regression
  Scenario: Cart01 :Adding and viewing the product to cart
    Given I have browsed the product
    And I am on a product detail page
    When I click on add to cart button
    And I click on go to cart button
    Then the product should be successfully added to my shopping cart