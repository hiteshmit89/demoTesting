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

    @And("The user is able to select practice")
    public void theUserIsAbleToSelectPractice() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getUsers().get(2).getPractice());
    }

    @When("The user is able to click on Profile icon")
    public void theUserIsAbleToClickOnProfileIcon() {
        PbNUIApp.practiceHomePage().clickOnUserProfileDropdown();
    }

    @Then("The user is able to click on settings")
    public void theUserIsAbleToClickOnSettings() {
        PbNUIApp.practiceHomePage().clickOnSettingsMenuItem();
    }

    @Then("The user is able to enable toggle for adyen feature")
    public void theUserIsAbleToEnableToggleForAdyenFeature() {
        PbNUIApp.settingsPage().clickToggleButton();
    }


}

