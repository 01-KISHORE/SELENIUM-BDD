package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.Dimension;

public class Window extends CommonHelper{
    private static Dimension dimension;
    public static String getWindow(){
       return driver.getWindowHandle();
    }

    public static void setWindowsSize(int width, int height){
        dimension = new Dimension(width,height);
        driver.manage().window().setSize(dimension);
    }
}
