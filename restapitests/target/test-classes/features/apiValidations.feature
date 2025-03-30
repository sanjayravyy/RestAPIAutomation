Feature: API Validations

Scenario: Validate the addPlace workflow using AddPlaceAPI
Given I have a addPlace payload
When I call the "AddPlaceAPI" with POST http request
Then I check API got successfully executed with status code 200
Then I check the "scope" should be "APP"
And I check the "status" should be "OK"
