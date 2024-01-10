package KISHORE.AUTOMATION.pageComponent;

import KISHORE.AUTOMATION.helper.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProjectComponent {

    public final WebDriver driver;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Projects")
    private WebElement projectsTabLink;

    @FindBy(how = How.LINK_TEXT, using = "List of projects")
    private WebElement projectsListLink;

    @FindBy(how = How.LINK_TEXT, using = "//h4[@class='name']/a[contains(text(),'Eclipse Hawk')]")
    private WebElement projectsListRowName;

    @FindBy(how = How.ID, using = "edit-combine")
    private WebElement projectSearchTxtFld;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement applyBtn;

    @FindBy(how = How.XPATH, using = "//h4[@class='name']")
    private List<WebElement> rowNames;

    public ProjectComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void filterProjectAndVerify(String projectName) {
        projectsTabLink.click();
        projectsListLink.click();
        projectSearchTxtFld.sendKeys(projectName);
        applyBtn.click();
        ExplicitWait.waitForAllElements(rowNames);
        if (!rowNames.isEmpty()) {
            int count = 0;
            for (WebElement row : rowNames) {
                if (count == 0 && row.findElement(By.xpath("//a[contains(text(),'" + projectName + "')]")).getText().contains(projectName)) {
                    System.out.println("Project Filter is working as expected");
                    break;
                } else {
                    System.out.println("Project Filter is not working as expected");
                    Assert.fail();
                }
            }
        } else {
            System.out.println("Filter Results Not Displayed");
            Assert.fail();
        }
    }
}