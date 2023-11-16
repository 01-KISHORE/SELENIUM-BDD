package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBox extends CommonHelper{
    public static void sendText(By locator, String value){
        ExplicitWait.waitForVisibility(locator);
        driver.findElement(locator).sendKeys(value);
    }
    public static void clearAndSendText(By locator, String value){
        ExplicitWait.waitForVisibility(locator);
        clear(locator);
        driver.findElement(locator).sendKeys(value);
    }
    public static void clear(By locator){
        driver.findElement(locator).clear();
    }
    public static void sendText(WebElement locator, String value){
        ExplicitWait.waitForVisibility(locator);
        locator.sendKeys(value);
    }
    public static void clickInTextBox(By locator){
        ExplicitWait.waitForVisibility(locator);
        getElement(locator).click();
    }

    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    public static String getText(WebElement locator) {
        return locator.getText();
    }
}

