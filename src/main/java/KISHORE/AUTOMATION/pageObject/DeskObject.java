package KISHORE.AUTOMATION.pageObject;

import KISHORE.AUTOMATION.pageComponent.EditProfileComponent;
import KISHORE.AUTOMATION.pageComponent.HomeComponent;
import KISHORE.AUTOMATION.pageComponent.LoginComponent;
import KISHORE.AUTOMATION.pageComponent.ProjectComponent;
import org.openqa.selenium.WebDriver;

public class DeskObject {

    public final WebDriver driver;
    public DeskObject deskObject;


    public DeskObject(WebDriver driver) {
        this.driver = driver;
    }

    public LoginComponent loginComponent() {
        return new LoginComponent(driver);
    }

    public HomeComponent homeComponent() {
        return new HomeComponent(driver);
    }

    public ProjectComponent projectComponent() {
        return new ProjectComponent(driver);
    }

    public EditProfileComponent editProfileComponent(){
        return new EditProfileComponent(driver);
    }
}