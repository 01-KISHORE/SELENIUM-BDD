package KISHORE.AUTOMATION.helper.multithreading;

import KISHORE.AUTOMATION.helper.ExplicitWait;
import org.openqa.selenium.By;

public class VisibilityOfElement extends Thread{
    By locator;
    int pollTime;
    public void setLocator(By locator) {
        this.locator = locator;
    }

    public void setPollTime(int pollTime) {
        this.pollTime = pollTime;
    }
    @Override
   synchronized public void run() {
            ExplicitWait.waitForVisibility(locator,pollTime);
    }
}
