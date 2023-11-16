package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;

public class LocatorGenerator {
    public static By generateLocatorFromString(String locatorString,String replacedValue){
       String locator = locatorString.replaceAll("replace",replacedValue);
       return By.xpath(locator);
    }
    public static By generateLinkLocatorFromText(String textValue){
        return By.xpath("//a[text()='"+textValue+"']");
    }
}
