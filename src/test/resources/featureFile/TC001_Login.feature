Feature: Login and Logout

  Scenario Outline: Login and Logout test

    When User logs into the ECLIPSE application with "<username>" and "<password>"
    Then Login result should be "<result>"
    When User logs out of application
    Then User should be logged out successfully

    Examples:
      | username            | password     | result |
      | AutomationEngineeer | Qwqwqw@12345 | true   |