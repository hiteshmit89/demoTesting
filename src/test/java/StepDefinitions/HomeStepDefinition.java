package StepDefinitions;

import Framework.Constants.Constants.Destination;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefinition {
    @Given("I login to PbN app")
    public void iLoginToPbNApp() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getUserEmail(3,2));
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPassword(3,2));
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @When("I click on practice name")
    public void iClickOnPracticeName() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPracticeName(3));
    }

    @Then("I will see activity for practice")
    public void iWillSeeActivityForPractice() {
        PbNUIApp.appHomePage().verifyWelcomeTextDisplayed();
    }
}