package StepDefinitions;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CampaignsStepDefinition {
    @Given("I click on profile dropdown")
    public void iClickOnProfileDropdown() {
        PbNUIApp.practiceHomePage().clickOnUserProfileDropdown();
    }


    @Then("I am redirected to the campaigns page")
    public void IamRedirectedToTheCampaignsPage() {
        PbNUIApp.campaignsPage().verifyCampaignsHeadingDisplayedOnCampaignsPage();
    }

    @When("I click on {string}")
    public void iClickOn(String dropdownOption) {
        PbNUIApp.navigator().selectProfileDropdownOption(dropdownOption);
    }
}
