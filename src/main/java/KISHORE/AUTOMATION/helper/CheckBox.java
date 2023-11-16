package KISHORE.AUTOMATION.helper;

import KISHORE.AUTOMATION.utility.CONSTANT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBox extends CommonHelper{
    public static void selectCheckBox(By locator) {
        AutoWait.autoWait(locator);
        selectCheckBox(driver.findElement(locator));
    }
    public static void unCheckCheckBox(By locator) {
        AutoWait.autoWait(locator);
        unCheckCheckBox(driver.findElement(locator));
    }
    public static boolean isSelected(By locator) {
        return isSelected(driver.findElement(locator));
    }
    public static boolean isSelected(WebElement element) {
        boolean flag = element.isSelected();
        return flag;
    }
    public static void selectCheckBox(WebElement element) {
        if (!isSelected(element))
            element.click();
    }
    public static void unCheckCheckBox(WebElement element) {
        ExplicitWait.hardWait(CONSTANT.BEFORE_ELEMENT);
        if (isSelected(element))
            element.click();
    }
    public static boolean getCheckBoxAttribute(By locator, String attributeName) {
       return Boolean.parseBoolean(getElement(locator).getAttribute(attributeName));
    }
}
