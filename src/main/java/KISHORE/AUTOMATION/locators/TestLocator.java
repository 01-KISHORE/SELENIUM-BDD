package KISHORE.AUTOMATION.locators;

import org.openqa.selenium.By;

public interface TestLocator {
    By countryTextField = By.cssSelector("#autocomplete");
    String dynamicDropDownValue =  "//ul[contains(@class,'ui-menu')]//li//div[text()='replace']";
//    By countryTextFielddfd = By.cssSelector("#autocomplete");
    By homeButton = By.xpath("//button[text()='Home']");

}
