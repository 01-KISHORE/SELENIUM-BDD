package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;

public class Actions extends CommonHelper {
    static org.openqa.selenium.interactions.Actions actions;
    public static Platform platformName;

    public static void actionsClick(WebElement element) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.click(element).perform();
    }

    public static void sendText(By locator, String text) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.sendKeys(getElement(locator), text).perform();
    }

    public static void sendText(WebElement element, String text) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.sendKeys(element, text).perform();
    }

    public static void actionsContextClick(WebElement element) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.contextClick(element).perform();
    }

    public static void actionsDoubleClick(WebElement element) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.doubleClick(element).perform();
    }

    public static void actionsClickAndHold(WebElement element) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.clickAndHold(element).perform();

    }

    public static void actionsDragAndDrop(WebElement source, WebElement target) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.dragAndDrop(source, target);
    }

    public static void actionsMouseHover(WebElement target) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(target);
    }

    public static void pressKeyUP() {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).build().perform();
    }

    public static void pressKeyDown() {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    public static void pressTab() {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
    }

    public static void pressEnter() {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public static void copyPasteField(By locator, String value1, String value2) {
        actions = new org.openqa.selenium.interactions.Actions(driver);
        Keys cmdCtrl = platformName.is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
        actions.sendKeys(getElement(locator), value1)
                .sendKeys(Keys.ARROW_LEFT)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys(value2)
                .keyUp(cmdCtrl)
                .perform();
    }
}