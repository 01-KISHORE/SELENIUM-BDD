Feature: Projects tab testing

  Scenario: Projects Filter

    When User logs into the ECLIPSE application with "AutomationEngineeer" and "Qwqwqw@12345"
    Then Login result should be "true"
    And Opens "Projects" tab on Home Page
    And Filter the Projects as Eclipse Hawk and verify the filter results