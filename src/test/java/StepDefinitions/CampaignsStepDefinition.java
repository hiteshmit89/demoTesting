package StepDefinitions;


import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CampaignsStepDefinition {
    @Given("I click on profile dropdown")
    public void iClickOnProfileDropdown(){
        PbNUIApp.practiceHomePage().clickOnUserProfileDropdown();
    }

    @When("I click on Campaigns")
    public void IClickOnCampaigns(){
        PbNUIApp.practiceHomePage().clickOnCampaignsMenuItem();
    }

    @Then("I am redirected to the campaigns page")
    public void IamRedirectedToTheCampaignsPage(){
        PbNUIApp.campaignsPage().verifyCampaignsHeadingDisplayedOnCampaignsPage();
    }


}
