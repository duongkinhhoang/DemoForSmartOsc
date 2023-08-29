Feature: TestWeb kingpower

  @run
  Scenario: Verify result
    Given open home page
    When user click close ads
    And  user input keyword "E.g: Shirt" into search box
    And  user click on button search
    And  user choose first product
    Then verify product information detail


