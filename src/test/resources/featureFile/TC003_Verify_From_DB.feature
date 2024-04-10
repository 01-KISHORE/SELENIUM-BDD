Feature: Regular Expressions and Cucumber Annotation Example on Plain steps

  @DB
  Scenario: DB comply
    When User logs into the application with username "Dummy" and password "Login"
    And User updates his name as "KishoreN" and age as 26
    Then Verify the new name KishoreN and age 26 by executing the DB Query