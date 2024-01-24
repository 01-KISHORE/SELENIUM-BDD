package KISHORE.AUTOMATION.pageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class EditProfileComponent {

    public final WebDriver driver;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Welcome")
    private WebElement firstName;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Welcome")
    private WebElement lastName;

    @FindBys({      // Like "AND"
            @FindBy(how = How.CSS, using = "#edit-picture-upload"),
            @FindBy(how = How.XPATH, using = "//input[@type='file']")
    })
    private WebElement imageUploadButton;

    @FindAll({      // Like "OR"
            @FindBy(how = How.CSS, using = "#edit-picture-upload"),
            @FindBy(how = How.NAME, using = "password")
    })
    private List<WebElement> eitherCriteriaExample;

    @FindBy(how = How.XPATH, using = "//input[@autocomplete='current-password']")
    private WebElement currentPasswordTxtFld;

    @FindBy(xpath = "//button[@id='edit-submit']")
    private WebElement saveBtn;

    @FindBy(xpath = "//h4[@class='element-invisible']")
    private WebElement updateMessage;

    public EditProfileComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void updateProfile(File filePath, String password) {
        imageUploadButton.sendKeys(filePath.getAbsolutePath());
        currentPasswordTxtFld.sendKeys(password);
        saveBtn.click();
        Assert.assertNotEquals("The changes have been saved.", updateMessage.getText());
    }
}