package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends CommonHelper {
    public static void clickOnDropDown(By locator){
        ExplicitWait.waitForVisibility(locator);
        getElement(locator).click();
    }
    public static void selectClassDropDownByVisibleTxt(By selectTag,String value){
        AutoWait.autoWait(selectTag);
        Select select = new Select(getElement(selectTag));
        select.selectByVisibleText(value);
    }
    public static void selectClassDropDownByValue(By selectTag,String value){
        AutoWait.autoWait(selectTag);
        Select select = new Select(getElement(selectTag));
        select.selectByValue(value);
    }


    public static String getText(By locator) {
            return getElement(locator).getText();
    }

    public static String getText(WebElement locator) {
        return locator.getText();
    }
}
