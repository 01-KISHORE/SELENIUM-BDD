package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

public class ElementInfo extends CommonHelper{
    private static Rectangle rectangle;
    public static Boolean isDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }
    public static Boolean isDisplayed(WebElement locator){
        return locator.isDisplayed();
    }
    public static Boolean isEnabled(By locator){
        return getElement(locator).isEnabled();
    }
    public static Boolean isSelected(By locator){
        return getElement(locator).isSelected();
    }
    public static String getTagName(By locator){
        return getElement(locator).getTagName();
    }
    public static Dimension getDimension(By locator){
        rectangle = getElement(locator).getRect();
        return rectangle.getDimension();
    }
    public static int getElementWidth(By locator){
        rectangle = getElement(locator).getRect();
        return rectangle.getWidth();
    }
    public static int getElementHeight(By locator){
        rectangle = getElement(locator).getRect();
        return rectangle.getHeight();
    }
    public static int getXCoordinate(By locator){
        rectangle = getElement(locator).getRect();
        return rectangle.getX();
    }
    public static int getYCoordinate(By locator){
        rectangle = getElement(locator).getRect();
        return rectangle.getY();
    }
    public static String getCssValue(By locator, String cssAttribute){
        return getElement(locator).getCssValue(cssAttribute);
    }
    public static String getText(By locator) {
        AutoWait.autoWait(locator);
        return driver.findElement(locator).getText();
    }
    public static String getText(WebElement locator) {
        return locator.getText();
    }


}
