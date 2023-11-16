package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Link extends CommonHelper{
    public static void click(By locator){
        AutoWait.autoWaitButton(locator);
        getElement(locator).click();
    }
    public static void click(WebElement locator){
        AutoWait.autoWaitButton(locator);
        locator.click();
    }
    public static boolean isLinkDisplayed(By locator)
    {
        try {
            return ElementInfo.isDisplayed(locator);
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public static String getText(By locator) {
        AutoWait.autoWaitButton(locator);
        return getElement(locator).getText();
    }
    public static String getText(WebElement locator) {
        AutoWait.autoWaitButton(locator);
        return locator.getText();
    }
}
