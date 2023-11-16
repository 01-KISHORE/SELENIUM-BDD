package KISHORE.AUTOMATION.helper;

import KISHORE.AUTOMATION.utility.CONSTANT;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class ExplicitWait extends CommonHelper {

    public static void hardWait(int timeValue) {
        try {
            Thread.sleep(timeValue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForVisibility(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitForElementsToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementsToBeClickable(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /*
     *Auto wait
     */
    public static void waitForVisibility(By locator, int pollingTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pollingTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementsToBeClickable(By locator, int pollingTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pollingTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForVisibility(WebElement locator, int pollingTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pollingTime));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitForElementsToBeClickable(WebElement locator, int pollingTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pollingTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilWindowOpen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(numberOfWindowsToBe(2));
    }

//  --------------------------------------------------------------------------------------------------------------------

    public static void waitForAllElements(List<WebElement> ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOfAllElements(ele));
    }
}
