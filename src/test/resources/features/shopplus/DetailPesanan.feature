@regress @smoke @shopplus

Feature: Verify All Feature on Detail Produk

  Background: User successfully access page
    Given user access page shop plus "1680582"
    Then system display title page : Detail Pesanan

  @pelajari
  Scenario: Verify system display cart page with click on cart icon
    And system display text "kamu masuk sebagai guest" on top
    Then system display button pelajari

  @pelajari
  Scenario: Verify system display modal guest information
    And user click on pelajari button
    Then system display modal guest information

  @pelajari
  Scenario: Verify system close guest information
    And user click close pelajari
    Then system hide user information

  @price
  Scenario: Verify price
    And the total price should be "4610"

  @stock
  Scenario: Verify stock is visible
    And system display stock of product

  @increase-qty
  Scenario: Verify increase qty
    When user clicks the increment button 4 times
    Then the quantity should increase by 4 times

  @increase-qty-max
  Scenario: Verify increase qty
    When user clicks increment button until max limit of 5
    Then the quantity should not exceed the max limit of 5
    And the increment button should be disabled

  @add-to-cart
  Scenario: Verify system display modal product
    And user click on add to cart
    Then system verify product added on modal

  @add-to-cart
  Scenario: Verify detail product after click modal
    When user clicks the increment button 2 times
    And user click on add to cart
    And user click on modal product
    Then user add 2 qty

  @delete-cart
  Scenario: Verify detail product after click delete
    When user clicks the increment button 2 times
    And user click on add to cart
    And user click on modal product
    Then user click on delete button

  @add-to-cart22
  Scenario: Add other product
    And user click on add to cart
    And user click on add to cart other product 1
    And user click on add to cart other product 2
#    Then system display