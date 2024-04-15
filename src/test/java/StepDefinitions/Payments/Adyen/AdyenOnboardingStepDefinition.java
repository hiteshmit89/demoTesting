package StepDefinitions.Payments.Adyen;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdyenOnboardingStepDefinition {


    @Given("I enter credentials")
    public void i_enter_credentials() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getPractices().getFirst().getUsers().get(2).getEmail());
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPractices().getFirst().getUsers().get(2).getPassword());
    }

    @When("I click login button")
    public void iClickLoginButton() {
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @Then("I am redirected to home page")
    public void i_am_redirected_to_home_page() {
        PbNUIApp.appHomePage().verifyUserHeaderIsDisplayed();
    }

    @And("I am able to select practice")
    public void iAmAbleToSelectPractice() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getUsers().get(2).getPractice());
    }

    @And("I click on Profile icon")
    public void iClickOnProfileIcon() {
        PbNUIApp.practiceHomePage().clickOnUserProfileDropdown();
    }

    @Then("I am able to click on settings")
    public void iAmAbleToClickOnSettings() {
        PbNUIApp.practiceHomePage().clickOnSettingsMenuItem();
    }

    @Then("I am able to enable toggle for adyen feature")
    public void iAmAbleToEnableToggleForAdyenFeature() {
        PbNUIApp.settingsPage().clickToggleButton();
    }


}

