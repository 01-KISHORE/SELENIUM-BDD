package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouse extends  CommonHelper{
    private static Actions action;
    /*
     * This class is used to perform mobile action
     */
    public static void mouseClick(By locator)
    {
        action =new Actions(driver);
        action.moveToElement(driver.findElement(locator)).click().build().perform();
    }
    public static void mouseHover(By locator) {
        action =new Actions(driver);
        action.moveToElement(driver.findElement(locator)).build().perform();
    }
    public static void scrollToElement(By locator){
        action =new Actions(driver);
   //     action.scrollToElement(getElement(locator)).perform();
    }
    public static void scrollToElement(WebElement locator){
        action =new Actions(driver);
    //    action.scrollToElement(locator).perform();
    }

}
