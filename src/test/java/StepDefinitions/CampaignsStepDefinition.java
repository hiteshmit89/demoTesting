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
    public void IamRedirectedToTheCampaignsPage() {
        PbNUIApp.campaignsPage().verifyCampaignsHeadingDisplayedOnCampaignsPage();
    }

    @When("I click on {string}")
    public void iSelectProfileDropdownOption(String dropdownOption) {
        PbNUIApp.practiceHomePage().iClickOn(dropdownOption);
    }


    @Then("I am redirected to Follow-up campaigns tab")
    public void iAmRedirectedToFollowUpCampaignsTab() throws InterruptedException {
        PbNUIApp.campaignsPage().verifyFollowUpPageUi();
    }
}
