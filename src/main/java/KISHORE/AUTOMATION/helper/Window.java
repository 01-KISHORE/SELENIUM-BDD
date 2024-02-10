package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.Dimension;

import java.util.Set;

public class Window extends CommonHelper {

    private static Dimension dimension;

    public static String getWindow() {
        return driver.getWindowHandle();
    }

    public static void setWindowsSize(int width, int height) {
        dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
    }

    public static void switchTab(String tabTitleToSwitch) {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String window : allWindowHandles) {
            String tabTitle = driver.switchTo().window(window).getTitle();
            if (tabTitle.equals(tabTitleToSwitch)) {
                System.out.println("Switched to " + tabTitleToSwitch + "Tab successfully");
                break;
            }
        }
    }
}