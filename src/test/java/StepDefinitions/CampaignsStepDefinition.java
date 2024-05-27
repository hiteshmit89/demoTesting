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

    @Then("I check for {string} UI")
    public void iAmRedirectedToFollowUpCampaignsTab(String campaignName) {
        PbNUIApp.campaignsPage().verifyFollowUpPageUiFor(campaignName);
    }

    @When("I try to edit and save email template of primary early reminder with invalid merge tag notification")
    public void iTryToEditAndSaveEmailTemplateOfPrimaryEarlyReminderWithInvalidMergeTagNotification() {
        PbNUIApp.campaignsPage().clickOnAppointmentRemindersCampaign();
        PbNUIApp.campaignsPage().clickOnPrimaryEarlyReminderEditEmailTemplateButton();
        PbNUIApp.campaignsPage().clickOnPreHeaderAndSelectPlaceholder("{{ first_appointment_time_of_day }}");
    }

    @Then("I will be able to edit and save email template of primary early reminder invalid merge tag notification")
    public void iWillBeAbleToEditAndSaveEmailTemplateOfPrimaryEarlyReminderInvalidMergeTagNotification() {
        PbNUIApp.campaignsPage().verifyErrorToastMessageDisplayed();
    }
}
