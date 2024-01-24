package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.*;

public class ElementInfo extends CommonHelper {

    private static Rectangle rectangle;

    public static Boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public static Boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public static Dimension getElementDimension(WebElement element) {
        rectangle = element.getRect();
        return rectangle.getDimension();
    }

    public static int getElementWidth(WebElement element) {
        rectangle = element.getRect();
        return rectangle.getWidth();
    }

    public static int getElementHeight(WebElement element) {
        rectangle = element.getRect();
        return rectangle.getHeight();
    }

    public static int getElementXCoordinate(WebElement element) {
        rectangle = element.getRect();
        return rectangle.getX();
    }

    public static int getElementYCoordinate(WebElement element) {
        rectangle = element.getRect();
        return rectangle.getY();
    }

    public static String getCssValue(WebElement element, String cssAttribute) {
        return element.getCssValue(cssAttribute);
    }
}