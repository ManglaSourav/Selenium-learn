Feature: Get airline details

  Scenario: Get airline details by ID
    Given url 'https://jsonplaceholder.typicode.com/todos'
    When method get
    Then status 200
