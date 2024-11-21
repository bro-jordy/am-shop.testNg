@regress @smoke @payment

Feature: Payment

  @payment
  Scenario Outline: Payment - "<Payment>"
    Given user access page shop plus 1680582
    And user click on add to cart
    Then user click on next button to address
    Then user click on next button to shipping
    And user click courier button "<Courier>"
    Then user select payment "<Payment>"
    And system display thankyou page


    Examples:
    | Courier               | Payment                   |
    | JNEREGREGULAR         | Go-Pay                    |
    | JNEREGREGULAR         | ShopeePay/SpayLater       |
    | SAPEXPRESSREGREGULAR  | Virtual Account BCA       |
    | SAPEXPRESSREGREGULAR  | Virtual Account BRI       |
    | SAPEXPRESSREGREGULAR  | Virtual Account Permata   |
    | SAPEXPRESSREGREGULAR  | Virtual Account MNC Bank  |
