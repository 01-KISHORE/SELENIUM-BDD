package KISHORE.AUTOMATION.helper;

import KISHORE.AUTOMATION.utility.CONSTANT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutoWait extends CommonHelper {

     public static void autoWaitTextBox(By locator) {
        for (int i = 1; i <= 5; i++) {
            ExplicitWait.waitForVisibility(locator,1);
            if(ElementInfo.isDisplayed(locator))
                break;
        }
        JavaScriptExecutor.scrollIntoView(locator);
    }

    public static void autoWait(By locator) {
        for (int i = 1; i <= 5; i++) {
            ExplicitWait.waitForVisibility(locator,1);
            if(ElementInfo.isDisplayed(locator))
                break;
        }
        JavaScriptExecutor.scrollIntoView(locator);
    }
     public static void autoWaitButton(By locator) {
        for (int i = 1; i <= CONSTANT.STEP_RETRY; i++) {
            ExplicitWait.waitForVisibility(locator,1);
            if(ElementInfo.isDisplayed(locator))
                break;
        }
         JavaScriptExecutor.scrollIntoView(locator);
        for (int i = 1; i <= CONSTANT.STEP_RETRY; i++) {
            ExplicitWait.waitForElementsToBeClickable(locator,1);
        }
    }
    public static void autoWaitTextBox(WebElement locator) {
        for (int i = 1; i <= CONSTANT.STEP_RETRY; i++) {
            ExplicitWait.waitForVisibility(locator,1);
            if(ElementInfo.isDisplayed(locator))
                break;
        }
        Mouse.scrollToElement(locator);
    }
    public static void autoWaitButton(WebElement locator) {
        for (int i = 1; i <= CONSTANT.STEP_RETRY; i++) {
            ExplicitWait.waitForVisibility(locator,1);
            if(ElementInfo.isDisplayed(locator))
                break;
        }
        Mouse.scrollToElement(locator);
        for (int i = 1; i <= CONSTANT.STEP_RETRY; i++) {
            ExplicitWait.waitForElementsToBeClickable(locator,1);
        }
    }
    public  static void autoWaitWindowOpen()
    {
        for (int i = 1; i <= CONSTANT.STEP_RETRY; i++) {
            ExplicitWait.waitUntilWindowOpen();
        }
    }
    public static void autoWaitAlert(){
         boolean flag = false;
        for (int i = 1; i <= CONSTANT.STEP_RETRY; i++) {
            if(flag == false) {
                flag = Alerts.isAlertPresent();
                ExplicitWait.hardWait(1000);
            }
        }
    }

}
