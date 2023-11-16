package KISHORE.AUTOMATION.helper;

import org.openqa.selenium.Cookie;

import java.util.Set;

public class Cookies extends CommonHelper{
    public static void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }
    public static void deleteCookieByName(String cookieName){
        driver.manage().deleteCookieNamed(cookieName);
    }
    public static void deleteCookieObject(Cookie cookieObject){
        driver.manage().deleteCookie(cookieObject);
    }
    public static Set<Cookie> getAllCookiesObject(){
        return driver.manage().getCookies();
    }
    public static Cookie getCookieByName(String cookieName){
        return driver.manage().getCookieNamed(cookieName);
    }
}
