package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.WebElement;

public class Frames extends CommonHelper {

    // switchTo.frame() is OVERLOADED method, Switch can be done with ID, Name and Index
    // ID/NAME: "only value of Frame's Id or name"
    // Address: "locator of the frame"
    // INDEX: "only number/index of frame"

    public static void switchToFrame(WebElement addressOrElement) {
        driver.switchTo().frame(addressOrElement);
    }

    public static void switchToFrame(String idOrName) {
        driver.switchTo().frame(idOrName);
    }

    public static void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public static void switchToImmediateParentFrame() {
        driver.switchTo().parentFrame();
    }

    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}