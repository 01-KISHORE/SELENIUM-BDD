package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Pen extends CommonHelper{
    public static Actions action;
    public Pen() {
        action =new Actions(driver);
    }
    public static void penAction(By locator, int xOffset, int yOffset){
//        action.setActivePointer(PointerInput.Kind.PEN,"default pen").moveToElement(getElement(locator))
//                .clickAndHold().moveByOffset(xOffset,yOffset).release().perform();
    }
}
