package StepDefinitions;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppointmentInsuranceFeature {
    @When("I click on appointments Setting tab and deactivate insurance settings")
    public void iClickOnAppointmentsSettingTabAndDeactivateInsuranceSettings() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnSetupInsurance();
    }

    @And("I click on appointments tab and try to book appointment")
    public void iClickOnAppointmentsTabAndTryToBookAppointment() {
    }

    @Then("I will not be able to see insurance page on appointment booking page.")
    public void iWillNotBeAbleToSeeInsurancePageOnAppointmentBookingPage() {

    }


}
