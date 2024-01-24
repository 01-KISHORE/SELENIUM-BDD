package KISHORE.AUTOMATION.helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class RobotActions extends CommonHelper {

    public static void robotLeftClick() throws AWTException {
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public static void robotMultipleClicks(int count) throws AWTException {
        for (int i = 1; i <= count; i++) {
            RobotActions.robotLeftClick();
        }
    }

    public static void robotRightClick() throws AWTException {
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

    public static void robotMiddleClick() throws AWTException {
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
    }

    public static void robotMouseMove(int x, int y) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(x, y);
    }

    public static void robotMouseWheel(int scrollUnit) throws AWTException {
        //  Value is in units not Pixels, can be positive(Down) or negative(Up)
        Robot robot = new Robot();
        robot.mouseWheel(scrollUnit);
    }

    public static void robotPressUpArrow() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
    }

    public static void robotPressDownArrow() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
    }

    public static void robotPressTAB() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    public static void robotPressENTER() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void robotControlC() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static void robotControlV() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static void robotCaptureScreenShot() throws AWTException, IOException {
        Robot robot = new Robot();
        java.awt.Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // Get Screen Size
        BufferedImage img = robot.createScreenCapture(new Rectangle(size)); // Capture ScreenShot
        File path = new File("D:/IWS/RobotCAPTURE_" + new Date().getTime() + ".jpg"); // Store image into file
        ImageIO.write(img, "JPG", path); // Write image path
    }
}