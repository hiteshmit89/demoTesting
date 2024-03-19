package StepDefinitions.Payments.Adyen;

import Framework.Root.PbNUIApp;
import Pages.AppHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdyenOnboardingStepDefinition {
    @When("The user is able to click on Profile icon")
    public void theUserIsAbleToClickOnProfileIcon() {
        PbNUIApp.practiceHomePage().clickOnUserProfileDropdown();
    }

    @Then("The user is able to click on settings")
    public void theUserIsAbleToClickOnSettings() {
        PbNUIApp.practiceHomePage().clickOnSettingsMenuItem();
    }

    @And("The user is able to enable toggle for adyen feature")
    public void theUserIsAbleToEnableToggleForAdyenFeature() {
        PbNUIApp.settingsPage().clicktoggleButton();
    }
}

