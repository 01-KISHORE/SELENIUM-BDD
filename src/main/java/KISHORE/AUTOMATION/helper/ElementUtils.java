package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementUtils extends CommonHelper {

    public static WebElement webElementByReplacingText(String locatorText, String textToReplace) {
        return driver.findElement(By.xpath(locatorText.replaceAll("replace", textToReplace)));
    }
}