package KISHORE.AUTOMATION.helper;

import KISHORE.AUTOMATION.utility.CONSTANT;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox extends CommonHelper {

    public static boolean isChecked(final WebElement element) {
        boolean isChecked = false;
        try {
            isChecked = element.isSelected();
        } catch (Exception e) {
            System.out.println(
                    "CHECKBOX STATUS retrieval FAILED on element >>> " + element + " ----------" + e.getStackTrace());
        }
        return isChecked;
    }

    public void setCheckboxAs(final WebElement ele, final boolean check) {
        try {
            if ((ele.isSelected() && !check) || (!ele.isSelected() && check)) {
                ele.click();
            }
        } catch (Exception e) {
            System.out.println("CHECKING CHECKBOX FAILED on element >>> " + ele + " ----------" + e.getStackTrace());
        }
    }

    public static void checkCheckboxByAttribute(WebElement element, String attributeName, boolean checkboxToBe) {
        ExplicitWait.waitUntilElementIstReady(element);
        if (!Boolean.parseBoolean(element.getAttribute(attributeName)) && checkboxToBe) {
            element.click();
        } else if (Boolean.parseBoolean(element.getAttribute(attributeName)) && !checkboxToBe) {
            element.click();
        }
    }

    public void chkMultipleCheckBox(String constX) {
        try {
            List<WebElement> elements = driver.findElements(By.xpath(constX));
            for (int i = 1; i < elements.size() + 1; i++) {
                String xpathExpression = constX + "[" + i + "]";
                WebElement ele = driver.findElement(By.xpath(xpathExpression));
                if (!isChecked(ele)) {
                    ele.click();
                }
            }
        } catch (Exception e) {
            System.out.println("CHECK MULTIPLE CHECKBOX FAILED >>> " + e.getStackTrace());
        }
    }
}