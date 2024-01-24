package KISHORE.AUTOMATION.helper;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class JavaUtils {

    public static void copyToClipboard(String textToCopy) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(textToCopy);
        clipboard.setContents(stringSelection, stringSelection);
    }
}
