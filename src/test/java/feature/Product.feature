Feature: Product Feature
  
  Description: This feature will be used to add products to cart in SwagLabs Application

  Background: 
    Given PF User has opened the SawagLabs applications
    When PF User enters username "standard_user"
    And PF User enters correct password "secret_sauce"
    And PF User clicks on Login button

  @ProductFeature
  Scenario Outline: Verify that User able to add the single product to the cart
    Given PF User should be landed on the Products Page
    And PF User selects a single product and Click Add to Cart button "<Product>"
    Then PF User should be able to view the product in Mycart

    Examples: 
      | Product                 |
      | Sauce Labs Bolt T-Shirt |

  @DataTable @ProductFeature
  Scenario: Verify that User able to add multiple product to the cart
    Given PF User should be landed on the Products Page
    And PF User selects Product and clicks on Add to Cart button
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    Then PF User should able to see the products in My Cart
