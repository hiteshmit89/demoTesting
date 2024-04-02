package StepDefinitions;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CampaignsStepDefinition {
    @Given("I click on profile dropdown")
    public void iClickOnProfileDropdown() {
        PbNUIApp.practiceHomePage().clickOnUserProfileDropdown();
    }

    @Then("I am redirected to the campaigns page")
    public void iAmRedirectedToTheCampaignsPage() {
        PbNUIApp.campaignsPage().verifyCampaignsHeadingDisplayedOnCampaignsPage();
    }

    @When("I click on {string} dropdown option")
    public void iSelectProfileDropdownOption(String dropdownOption) {
        PbNUIApp.practiceHomePage().iClickOn(dropdownOption);
    }

    @Then("I check for Follow-up campaigns UI")
    public void iAmRedirectedToFollowUpCampaignsTab()  {
        PbNUIApp.campaignsPage().verifyFollowUpPageUi();
    }
}
