package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class Alerts extends CommonHelper{
    // Switch to alert
    public static Alert getAlert() {
        return driver.switchTo().alert();
    }
    // Accept the alert
    public static void AcceptAlert() {
        getAlert().accept();
    }
    // Dismiss the alert
    public static void DismissAlert() {
        getAlert().dismiss();
    }
    /*
     * Get text associated with alert
     *
     * @return String value of the alert message.
     */
    public static String getAlertText() {
        AutoWait.autoWaitAlert();
        return getAlert().getText();

    }
    /*
     * Check whether alert is present or not
     *
     * @return the boolean value
     */
    public static boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /*
     * Accept if alert is present or else return boolean value
     */
    public static void AcceptAlertIfPresent() {
        if (!isAlertPresent())
            return;
        AcceptAlert();
    }

    /*
     * Accept if alert is present or else return boolean value
     */
    public static void DismissAlertIfPresent() {
        if (!isAlertPresent())
            return;
        DismissAlert();
    }

    /*
     * Accept Prompt alert if alert is present after sending the text or else return
     * boolean value.
     */
    public static void AcceptPrompt(String text) {
        if (!isAlertPresent())
            return;
        org.openqa.selenium.Alert alert = getAlert();
        alert.sendKeys(text);
        alert.accept();
    }
}
