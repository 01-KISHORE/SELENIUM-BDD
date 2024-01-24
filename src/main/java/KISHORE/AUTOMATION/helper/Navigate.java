package KISHORE.AUTOMATION.helper;

public class Navigate extends CommonHelper {

    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void navigateForward() {
        driver.navigate().forward();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }
}