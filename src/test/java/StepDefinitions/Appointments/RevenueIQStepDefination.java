package StepDefinitions.Appointments;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class RevenueIQStepDefination {
    @When("I navigate to the RevenueIQ page")
    public void iNavigateToTheRevenueIQPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.ReveneueIQ);
    }
    @And("I click on the Treatment")
    public void iClickOnTheTreatment() {
        PbNUIApp.revenueIQPage().clickOnTreatment();
    }

    @And("I Click on the Search Button")
    public void iClickOnTheSearchButton() {
        PbNUIApp.revenueIQPage().clickOnSearchButton();
    }

    @And("I Click on Patient Name to open their Patient Window")
    public void iClickOnPatientNameToOpenTheirPatientWindow() {
        PbNUIApp.revenueIQPage().clickOnPatientNameToOpenTheirPatientWindow();
    }
}