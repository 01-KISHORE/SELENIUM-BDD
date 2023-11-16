package KISHORE.AUTOMATION.Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface GetText {
    public String getText(By locator);
    public String getText(WebElement locator);
}
