Feature: Edit Profile Details

  Scenario Outline: Profile Details
    Given User logs into the ECLIPSE application with "<username>" and "<password>"
    And User does Edit PROFILE by uploading new ProfilePicture "<displayPic>", "<password>"
    Then User logs out of application
    
    Examples:
      | username            | password     | displayPic                                        |
      | AutomationEngineeer | Qwqwqw@12345 | \src\main\resources\sikkuliImage\BlueHome.png     |
      | AutomationEngineeer | Qwqwqw@12345 | \src\main\resources\sikkuliImage\YellowSearch.png |