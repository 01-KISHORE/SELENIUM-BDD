package base;

import KISHORE.AUTOMATION.helper.CommonHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import KISHORE.AUTOMATION.utility.CONSTANT;
import KISHORE.AUTOMATION.pageObject.DeskObject;

import java.util.ArrayList;
import java.util.List;

public class BaseClass extends CommonHelper {

    public BaseClass() {
        super();
    }

    public List<Object> launchBrowser() {
        if (CONSTANT.BROWSER_TYPE.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cap);
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
        DeskObject deskObject = new DeskObject(driver);
        List<Object> objects = new ArrayList<>();
        objects.add(driver);
        objects.add(deskObject);
        return objects;
    }
}