package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends CommonHelper {

    public void selectOption(WebElement element, String visibleIndexValue, String value) {
        // DropDown (enum) is attached for "type" parameter
        // this.uiHome.selectOption(null, DropDown.VISIBLETEXT.toString(), "Option1");
        try {
            Select dropdown = new Select(element);
            switch (visibleIndexValue) {
                case "visibleText":
                    dropdown.selectByVisibleText(value);
                    break;
                case "index":
                    dropdown.selectByIndex(Integer.parseInt(value));
                    break;
                case "value":
                    dropdown.selectByValue(value);
                    break;
                default:
                    System.out.println("DROPDOWN SYNTAX: 1-WebElement, 2-type(visibleText,index,value), 3-value");
                    break;
            }
        } catch (Exception e) {
            System.out.println("DROPDOWN SELECTION FAILED");
        }
    }
}