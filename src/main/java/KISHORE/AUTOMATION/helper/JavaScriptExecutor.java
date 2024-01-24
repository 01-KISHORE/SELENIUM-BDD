package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class JavaScriptExecutor extends CommonHelper {

    private static JavascriptExecutor js;
    // js.executeScript(script, args);

    public static void jsForceClick(By locator) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public static void jsForceClick(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void jsEnterText(String elementID, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('" + elementID + "').value='" + text + "'"); //set the text
        String enteredText = (String) js.executeScript("return document.getElementById('" + elementID + "').value"); //get the text
        if (!text.contentEquals(enteredText)) System.out.println("JS FAILED to enter text");
    }

    public static void javaScriptSendKeys(By locator, String value) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + value + "';", getElement(locator));
    }

    public static WebElement jsGetElementByID(String elementID) {
        // Different ways in locating element in JS: Only one single method(getElementById) returns the WebElement and the rest are returning the list of WebElements
        // getElementById
        // getElementsByName
        // getElementsByClass
        // getElementsByTagName
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (WebElement) jsExecutor.executeScript("return document.getElementById('" + elementID + "')");
    }

    public static WebElement jsFetchDOMElement(String type, String ID_NAME_CLASS_TAGNAME) {
        switch (type) {
            case "ID": {
                String scriptElement = "return document.getElementById('" + ID_NAME_CLASS_TAGNAME + "')";
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (WebElement) js.executeScript(scriptElement);
            }
            case "NAME": {
                String scriptElement = "return document.getElementsByName('" + ID_NAME_CLASS_TAGNAME + "')";
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (WebElement) js.executeScript(scriptElement);
            }
            case "CLASS": {
                String scriptElement = "return document.getElementsByClass('" + ID_NAME_CLASS_TAGNAME + "')";
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (WebElement) js.executeScript(scriptElement);
            }
            case "TAGNAME": {
                String scriptElement = "return document.getElementsByTagName ('" + ID_NAME_CLASS_TAGNAME + "')";
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (WebElement) js.executeScript(scriptElement);
            }
        }
        return null;
    }

    public static WebElement jsGetElementByXpath(String xpath) {    //NOT WORKING
        // SYNTAX: document.evaluate(xpathExpression, contextNode, namespaceResolver, resultType, result).singleNodeValue;
        String scriptExecutor = "return document.evaluate('" + xpath + "',document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(scriptExecutor);
    }

    public static WebElement jsGetElementByCSS(String cssLocator) { // NOT WORKING
        String scriptElement = "return document.querySelector('" + cssLocator + "')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(scriptElement);
    }

    public static String jsGetText(String locator) {
        js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return document.getElementById('" + locator + "').value");
    }

    public static void jsScrollIntoView(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"center\"});", element);
    }

    public static HashMap<String, String> jsAppDetails() {
        js = (JavascriptExecutor) driver;
        HashMap<String, String> appDetails = new HashMap<String, String>();
        appDetails.put("domainName", js.executeScript("return document.domain;").toString());
        appDetails.put("url", js.executeScript("return document.URL;").toString());
        appDetails.put("title", js.executeScript("return document.title;").toString());
        return appDetails;
    }

    public static void jsOpenNewPage(String url) {
        // From: https://rahulshettyacademy.com/AutomationPractice/
        // To  : https://rahulshettyacademy.com/AutomationPractice/wonderla.com (if url = "wonderla")
        js = (JavascriptExecutor) driver;
        js.executeScript("window.location = '" + url + "'");
    }

    public static void jsRefreshBrowser() {
        // Refreshed Current page
        js = (JavascriptExecutor) driver;
        js.executeScript("location.reload()");
    }

    public static void jsWindowScrollBy(int x, int y) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public static void jsScrollToBottom() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight || document.documentElement.scrollHeight);");
    }

    public static void jsThrowAlert(String alertMessage) {
        js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + alertMessage + "');");
    }

    public static void jsHighlightElementAlways(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", element);
    }

    public static void jsHighlightElement(WebElement element) {
        try {
            for (int i = 1; i <= 2; i++) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                        "color: red; border: 3px solid red;");
                ExplicitWait.pause(0.75);
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                ExplicitWait.pause(0.5);
            }
        } catch (Exception e) {
            System.out.println("HIGHLIGHT ELEMENT FAILED >>> " + element + " ---------- " + e.getStackTrace());
        }
    }
}