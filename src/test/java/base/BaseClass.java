package base;

import KISHORE.AUTOMATION.helper.Alerts;
import KISHORE.AUTOMATION.helper.CommonHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import KISHORE.AUTOMATION.utility.CONSTANT;
import KISHORE.AUTOMATION.pageObject.DeskObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseClass extends CommonHelper {

    public BaseClass() {
        super();
    }

    public static List<Object> launchBrowser() {
        if (CONSTANT.BROWSER_TYPE.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cap);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (CONSTANT.BROWSER_TYPE.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (CONSTANT.BROWSER_TYPE.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (CONSTANT.BROWSER_TYPE.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CONSTANT.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));     // Selenium.TimeoutException.
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));      // Wait for asynchronous elements
        deskObject = new DeskObject(driver);
        List<Object> objects = new ArrayList<>();
        objects.add(driver);
        objects.add(deskObject);
        objects.add(new Alerts());
        return objects;
    }
}