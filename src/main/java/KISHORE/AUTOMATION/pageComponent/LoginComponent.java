package KISHORE.AUTOMATION.pageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginComponent {

    public final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='User Menu']")
    private WebElement userMenu;

    @FindBy(how = How.XPATH, using = "//a[@href='https://accounts.eclipse.org/user']")
    private WebElement viewMyAccountOption;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your email address']")
    private WebElement usernameTxtFld;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your password']")
    private WebElement passwordTxtFld;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(how = How.XPATH, using = "//h1[.='Welcome to Eclipse']|//a[.=' Log in']")
    private WebElement loginPage;

    @FindBy(how = How.XPATH, using = "//a[.='Allow cookies']")
    private WebElement acceptCookiesBtn;

    public LoginComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) throws InterruptedException {
//      userMenu.click();
//      viewMyAccountOption.click();
        usernameTxtFld.sendKeys(username);
        passwordTxtFld.sendKeys(password);
        submitBtn.click();
    }

    public void verifyLogout() {
        junit.framework.Assert.assertTrue(loginPage.isDisplayed());
    }

    public void acceptCookies() {
        acceptCookiesBtn.click();
    }
}