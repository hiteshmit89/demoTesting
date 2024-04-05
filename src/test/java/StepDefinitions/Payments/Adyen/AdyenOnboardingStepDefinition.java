package StepDefinitions.Payments.Adyen;

import Framework.Root.PbNUIApp;
import Pages.AppHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdyenOnboardingStepDefinition {

    @And("The user is able to select practice")
    public void theUserIsAbleToSelectPractice() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getPractice_name());

    }

    @When("The user is able to click on Profile icon")
    public void theUserIsAbleToClickOnProfileIcon() {
        PbNUIApp.practiceHomePage().clickOnUserProfileDropdown();
    }

    @And("The user is able to select practice")
    public void theUserIsAbleToSelectPractice() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getPractice_name());
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

