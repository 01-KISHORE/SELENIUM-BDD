package KISHORE.AUTOMATION.helper;

import KISHORE.AUTOMATION.utility.CONSTANT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class Alerts extends CommonHelper {

    public static Alert getAlert() {
        return driver.switchTo().alert();
    }

    public static void acceptAlert() {
        getAlert().accept();
    }

    public static void dismissAlert() {
        getAlert().dismiss();
    }

    public static String getAlertText() {
        return getAlert().getText();
    }

    public static boolean isAlertPresent() {
        boolean flag = false;
        try {
            for (int i = 1; i <= CONSTANT.STEP_RETRY; i++) {
                if (!flag) {
                    ExplicitWait.pause(1);
                    Alert alert = driver.switchTo().alert();
                    if (alert != null) {
                        flag = true;
                        break;
                    }
                }
            }
        } catch (NoAlertPresentException e) {
            flag = false;
        }
        return flag;
    }

    public static void acceptAlertIfPresent() {
        if (!isAlertPresent()) return;
        acceptAlert();
    }

    public static void dismissAlertIfPresent() {
        if (!isAlertPresent()) return;
        dismissAlert();
    }

    public static void AcceptPrompt(String text) {
        if (!isAlertPresent()) return;
        Alert alert = getAlert();
        alert.sendKeys(text);
        alert.accept();
    }
}