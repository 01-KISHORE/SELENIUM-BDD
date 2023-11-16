package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;

public class Frames extends CommonHelper{
    public static void switchToFrame(By locator){
        AutoWait.autoWait(locator);
        driver.switchTo().frame(getElement(locator));
    }
    public static void switchToFrame(String value){
        driver.switchTo().frame(value);
    }
    public static void switchToFrame(int value){
        driver.switchTo().frame(value);
    }
    public static void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
}
