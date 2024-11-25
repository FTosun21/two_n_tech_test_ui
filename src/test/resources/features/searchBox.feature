Feature: As a user ,I should be able to use search box

  @wip
  Scenario Outline: The user searches for news and navigates to selected news detail
    Given The user navigates to "<website>" url
    When The user clicks on the search button
    And The user enters "<searchInfo>" into the search box
    Then The user verifies that result for entry title contains "<searchInfo>"
    And The user clicks on <link_number> th news article
    Then The user should be navigated to the detail page of that article
    Examples:
      | website  | searchInfo | link_number |
      | 2nhaber_ | İstanbul   | 8           |



