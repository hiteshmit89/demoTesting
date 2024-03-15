package StepDefinitions.Payments.Adyen;

import Framework.Root.PbNUIApp;
import Pages.AppHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdyenOnboardingStepDefinition {

    @Given("The User is able to login")
    public void the_user_is_able_to_login() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getPractices().getFirst().getEmail());
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPractices().getFirst().getPassword());
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @And("The user is able to select practice")
    public void theUserIsAbleToSelectPractice() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getPractice_name());

    }

    @And("The user in on HomePage")
    public void theUserInOnHomePage() {
        AppHomePage.verifyWelcomeTextDisplayed();
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
        PbNUIApp.settingsPage().clicktoggleButton();
    }
}

