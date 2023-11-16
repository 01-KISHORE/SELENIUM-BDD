package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;

public class KeyBoard extends CommonHelper{
    static Actions action;
    public static Platform platformName;

    public static void pressKeyUP() {
        action =new Actions(driver);
        action.sendKeys(Keys.ARROW_UP).build().perform();
    }
    public static void pressDown() {
        action =new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
    }
    public static void pressEnter(){
        action =new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }
    public static void pressTab(){
        action =new Actions(driver);
        action.sendKeys(Keys.TAB).build().perform();
    }

    public static void sendText(By locator, String value){
        action =new Actions(driver);
        action.sendKeys(getElement(locator),value).perform();
    }
    public static void copyPasteField(By locator, String value1, String value2){
        action =new Actions(driver);
        Keys cmdCtrl = platformName.is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
                action.sendKeys(getElement(locator), value1)
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
