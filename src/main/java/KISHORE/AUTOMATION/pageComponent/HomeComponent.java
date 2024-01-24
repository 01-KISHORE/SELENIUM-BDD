package KISHORE.AUTOMATION.pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomeComponent {

    private final WebDriver driver;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Welcome")
    private WebElement welcome;

    @FindBy(how = How.XPATH, using = "//ul[@aria-labelledby='dropdownMenu']/li")
    private List<WebElement> userDropdownOptions;

    @FindBy(how = How.XPATH, using = "//span[@class='caret']")
    private WebElement userDropdown;

    @FindBy(how = How.XPATH, using = "//a[.=' Edit my account']")
    private WebElement editMyAccountOption;

    @FindBy(how = How.XPATH, using = "//a[.=' Log out']")
    private WebElement logoutOption;

    public HomeComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        userDropdown.click();
        logoutOption.click();
    }

    public void selectProfileOption(String option) {
        userDropdown.click();
        switch (option) {
            case "Logout": {
                logoutOption.click();
            }
            case "Edit my account": {
                editMyAccountOption.click();
            }
            default: {
                if (userDropdownOptions.isEmpty()) {
                    System.out.println("Profile Dropdown is not VIEWED");
                }
            }
        }
    }

    public void selectTab(String tabName) {
        switch (tabName) {
            case "Projects": {
                driver.findElement(By.linkText("Projects"));
            }
            case "Working Groups": {
                driver.findElement(By.linkText("Working Groups"));
            }
            case "Members": {
                driver.findElement(By.linkText("Members"));
            }
            case "More": {
                driver.findElement(By.linkText("More"));
            }
            default: {
                System.out.println("SELECTED : " + tabName + " tab");
            }
        }
    }

    public void verifyLogin(String result) {
        try {
            boolean messageDisplayed = welcome.isDisplayed();
            if (messageDisplayed && result.equalsIgnoreCase("true"))
                System.out.println("Valid User Successfully Logged IN");
            else if (!messageDisplayed && !result.equalsIgnoreCase("true"))
                System.out.println("Invalid User Failed to Log IN");
            else if (!messageDisplayed && result.equalsIgnoreCase("true")) {
                System.out.println("Valid User Not able to Log IN");
                Assert.fail();
            } else if (messageDisplayed && !result.equalsIgnoreCase("true")) {
                System.out.println("Invalid User successfully Log IN");
                Assert.fail();
            }
        } catch (NoSuchElementException e) {
            System.out.println("LOGIN EXCEPTION");
        }
    }
}