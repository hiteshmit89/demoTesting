package StepDefinitions.Appointments;

import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerificationOfDataAvailabilityAndBlockoutTimes {

    @When("I click on appointments Setting tab open provider setting")
    public void iClickOnAppointmentsSettingTabOpenProviderSetting() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnProviderEditButton();
    }

    @Then("I will be able to see days and block-out times visibility on appointment booking setting page")
    public void iWillBeAbleToSeeDaysAndBlockOutTimesVisibilityOnAppointmentBookingSettingPage() {
        PbNUIApp.appointmentsPage().verifyBlockOutTimes();
    }
}
