Feature: Trip plan
  A traveller is to pack for an upcoming business trip

  Background
    Given As a traveller
    And I want to know about the weather
    And So that I can travel comfortably

  @TripPlan
  Scenario: Pack for upcoming trip
    Given the temp reader and temp in celcius

  Scenario : verify clothing if weather is cold
    When temp is less than 20 for entire week
    And trip duration between Monday to Friday
    Then weather is cold
    Then traveller will pack woollens

  Scenario: : verify clothing if weather is not cold
    When temp is less than 20 for entire week
    And trip duration between Monday to Friday
    Then weather is not cold
    Then traveller will pack swim costume

