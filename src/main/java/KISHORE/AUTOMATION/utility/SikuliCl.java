package KISHORE.AUTOMATION.utility;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class SikuliCl {

    public static void clickOnImage(String imageLocation) throws FindFailed {
        Screen screen = new Screen();
        screen.find(imageLocation);
        screen.doubleClick(imageLocation);
    }
}