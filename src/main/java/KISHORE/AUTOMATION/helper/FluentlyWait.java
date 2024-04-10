package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FluentlyWait {

    public static void fluentlyWait(WebDriver driver){
        FluentWait<WebDriver> fluentlyWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
    }
}
