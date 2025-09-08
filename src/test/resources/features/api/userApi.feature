@api
Feature: User API
  Scenario: Get user by ID and validate schema
    Given api env loaded
    When I send a GET request to "/users/1"
    Then the response status code should be 200
    Then the response should match "schemas/user-schema.json"
