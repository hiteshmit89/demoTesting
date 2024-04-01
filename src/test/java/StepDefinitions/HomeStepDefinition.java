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
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getPractices().getFirst().getUsers().getFirst().getEmail());
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPractices().getFirst().getUsers().getFirst().getPassword());
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @When("I click on practice name")
    public void iClickOnPracticeName() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getPractice_name());
    }

    @Then("I will see activity for practice")
    public void iWillSeeActivityForPractice() {
        PbNUIApp.appHomePage().verifyWelcomeTextDisplayed();
    }

}
