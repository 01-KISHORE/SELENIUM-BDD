package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TestClass extends CommonHelper {

    public void test() throws AWTException, InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cap);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public static void main(String[] args) throws IOException, UnsupportedFlavorException, AWTException, InterruptedException {
        TestClass a = new TestClass();
        a.test();
    }
}