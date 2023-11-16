package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenShot extends CommonHelper{
    public static void takeScreenShot(){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File file = scrShot.getScreenshotAs(OutputType.FILE);
    }
}
