package stepDefinition;

import KISHORE.AUTOMATION.helper.Alerts;
import KISHORE.AUTOMATION.locators.TabOptions;
import KISHORE.AUTOMATION.utility.SikuliCl;
import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import KISHORE.AUTOMATION.pageObject.DeskObject;
import org.sikuli.script.FindFailed;

import java.io.File;
import java.util.List;

public class CommonSteps {

    public static WebDriver driver;
    public static DeskObject deskObject;
    private String name;
    private String age;

    //  GLOBAL HOOKS
    @Before(order = 0)
    public void configureBrowser() {
        System.out.println("TEST STARTED ");
        BaseClass baseClass = new BaseClass();
        List<Object> objects = baseClass.launchBrowser();
        driver = (WebDriver) objects.get(0);
        deskObject = (DeskObject) objects.get(1);
        Alerts alert = (Alerts) objects.get(2);
    }

    @Before(order = 1)
    public void hitURL() {
        System.out.println("Hitting URL");
        driver.get("https://accounts.eclipse.org");
    }

    @After(order = 1)
    public void teardown() {
        System.out.println("TEST COMPLETE");
        //  driver.quit();
    }

    //  LOCAL : TAGGED HOOKS
    @Before("@DB")
    public void configureDB() {
        System.out.println("DB Configuration done");
    }

    @After("@DB")
    public void closingDB() {
        System.out.println("DB instance Closed");
    }

    //  PARAMETER TYPE
    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean cBoolean(String value) {
        return Boolean.valueOf(value);
    }

    //  STEP-DEFINITIONS
    @When("User logs into the ECLIPSE application with {string} and {string}")
    public void login(String username, String password) throws FindFailed, InterruptedException {
        deskObject.loginComponent().acceptCookies();
        deskObject.loginComponent().login(username, password);
        //  SikuliCl.clickOnImage("./src/main/resources/sikkuliImage/YellowSearch.png");
    }

    @When("Opens {string} tab on Home Page")
    public void openTab(String tabName) {
//      deskObject.homeComponent().selectTab(TabOptions.Projects.toString());   //To know the options present use ENUM: TabOptions
//      deskObject.homeComponent().selectTab(tabName);
        deskObject.homeComponent().selectTab(String.valueOf(TabOptions.valueOf(tabName)));
    }

    @When("^Filter the Projects as ([^/”]*) and verify the filter results$")
    public void filterProject(String projectName) {
        deskObject.projectComponent().filterProjectAndVerify(projectName);
    }

    @When("User logs out of application")
    public void logout() {
        deskObject.homeComponent().logout();
    }

    @When("User does Edit PROFILE by uploading new ProfilePicture {string}, {string}")
    public void editProfile(String filePath, String password) throws FindFailed {
        deskObject.homeComponent().selectProfileOption("Edit my account");
        deskObject.editProfileComponent().updateProfile(new File(System.getProperty("user.dir") + filePath), password);
        SikuliCl.clickOnImage("./src/main/resources/sikkuliImage/YellowSearch.png");
        Alerts.isAlertPresent();
        Alerts.acceptAlert();
    }

    @Then("Login result should be {string}")
    public void verifyValidLogin(String result) {
        deskObject.homeComponent().verifyLogin(result);
    }

    @Then("User should be logged out successfully")
    public void verifyLogOut() {
        deskObject.loginComponent().verifyLogout();
    }

    //  New Test Case for DB Tag
    @When("^User logs into the application with username \"([^\"]+)\" and password \"([^\"]+)\"$")
    public void userLogsIntoTheApplicationWithUsernameAndPassword(String username, String password) {
        System.out.println("User successfully logged in with UN: " + username + ", and PW: " + password);
    }

    @When("^User updates his name as \"([^\"]+)\" and age as (\\d+)$")      //With double quotes
    public void userUpdatesHisNameAndAgeAs(String name, String age) {
        this.name = name;
        this.age = age;
        System.out.println("User successfully Updated his NAME: " + name + ", and AGE:" + age);
    }

    @Then("^Verify the new name ([^\"]+) and age (\\d+) by executing the DB Query$")
    //Without double quotes: String and digit
    public void verifyTheNewAgeByExecutingTheDBQuery(String name, String age) {
        if (this.name.equals(name) && this.age.equals(age)) {
            System.out.println("Verified name and age from DB");
        } else {
            System.out.println("NAME and AGE is NOT UPDATED");
        }
    }

    @Then("Testing Boolean Parameter type {cBoolean}")
    public void testParameterType(boolean boo) {
        if (boo) System.out.println("Boolean ParameterType is Working : " + boo);
    }
}