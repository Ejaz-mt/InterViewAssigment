Feature: Websturant search functionality and verification

  Scenario:  Testing Websturant functionality and Verification.
    Given User in on Websturant home Page
    When  User search for 'stainless work table' in the Websturant search box and enter
    Then  Ensuring every product item has the word "Table" its title.
    Then User add the last item found to Cart.
    And User Empty the Cart.