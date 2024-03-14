package StepDefinitions;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefinition {
    @Given("I login to PbN app")
    public void iLoginToPbNApp() {
        PbNUIApp.loginPage().enterEmail("chris.lau@practicenumbers.com");
        PbNUIApp.loginPage().enterPassword("ppp###2025");
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @When("I click on practice name")
    public void iClickOnPracticeName() {
        PbNUIApp.homePage().clickOnPracticeInPracticeInfoTable("Romans, Burke and Wagner");
    }

    @Then("I will see activity for practice")
    public void iWillSeeActivityForPractice() {
        PbNUIApp.homePage().verifyWelcomeTextDisplayed();
    }
}
