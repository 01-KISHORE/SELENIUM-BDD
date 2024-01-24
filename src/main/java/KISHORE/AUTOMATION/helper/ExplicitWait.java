package KISHORE.AUTOMATION.helper;

import KISHORE.AUTOMATION.utility.CONSTANT;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class ExplicitWait extends CommonHelper {

    public static void pause(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000L));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibility(By locator, int durationSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForVisibility(WebElement locator, int durationSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waituntilElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waituntilElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waituntilElementToBeClickable(By locator, int durationSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waituntilElementToBeClickable(WebElement locator, int durationSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilWindowOpen(int numberOfWindowsBefore) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(numberOfWindowsToBe(numberOfWindowsBefore + 1));
    }

    public static void waitForAllElements(List<WebElement> ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOfAllElements(ele));
    }

    public static void waitUntilElementIstReady(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CONSTANT.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}