Feature: Comparing UI and DB

  @DB
  Scenario: DB comply
    When User logs into the application with username "ReyMysterio69" and password "Qwqwqw@*^_+!$12"
    And User updates his name as "KishoreN" and age as 26
    Then Verify the new name KishoreN and age 26 by executing the DB Query