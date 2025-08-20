Feature: Google Search

  Scenario: Search for a term on Google
    Given I am on Google home page
    When I search for "OpenAI"
    Then results should be shown with the query "OpenAI"
