package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor extends CommonHelper{
    private static JavascriptExecutor executor;
    /*
     * JavaScript Executor to perform the action for JS file.
     */
    public static void forceClickJSE(By locator) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }
    public static void forceClickJSE(WebElement locator) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", locator);
    }

    /*
     * Get Text using java script executor
     */
    public static String getTextJSE(String locator) {
        executor = (JavascriptExecutor) driver;
        String text = (String) executor.executeScript("return document.getElementById('" + locator + "').value");
        return text;
    }

    public static void scrollIntoView(By locator) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"center\"});", driver.findElement(locator));
    }
    public static void javaScriptSendKeys(By locator, String value){
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='"+value+"';", getElement(locator));
    }

}
