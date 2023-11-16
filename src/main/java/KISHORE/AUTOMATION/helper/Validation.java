package KISHORE.AUTOMATION.helper;

import org.testng.Assert;

public class Validation {
    public static void validateText(String actualText, String expectedText){
        Assert.assertEquals(actualText,expectedText);
        System.out.println(actualText+" is equal to "+expectedText);
    }
}