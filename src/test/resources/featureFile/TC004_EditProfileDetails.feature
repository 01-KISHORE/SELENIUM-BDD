Feature: Edit Profile Details

    Scenario Outline: Profile Details
    When User logs into the ECLIPSE application with "<username>" and "<password>"
    And User does Edit PROFILE by uploading new ProfilePicture "<displayPic>", "<password>"

    Examples:
      | username            | password     | displayPic                                            |
      | AutomationEngineeer | Qwqwqw@12345 | D:\IWS\src\main\resources\sikkuliImage\img.png        |
      | AutomationEngineeer | Qwqwqw@12345 | D:\IWS\src\main\resources\sikkuliImage\SearchIcon.png |